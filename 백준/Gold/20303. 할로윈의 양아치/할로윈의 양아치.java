import java.util.*;
import java.io.*;

public class Main {
	static int N, M, K, ans = 0, cnt;
	static int[] candies;
	static int[][] dp;
	static boolean[] visited;
	static ArrayList<Integer>[] friends;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		candies = new int[N + 1];
		st = new StringTokenizer(br.readLine(), " ");

		visited = new boolean[N + 1];
		friends = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			friends[i] = new ArrayList<>();
			candies[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			friends[a].add(b);
			friends[b].add(a);
		}
		ArrayList<Node> list = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				cnt = 0;
				int candy = dfs(i);
				// System.out.println(i + ": " + candy);
				if (cnt < K) {
					list.add(new Node(cnt, candy));
					// ans = Math.max(ans, candy);
				}
			}
		}
		Collections.sort(list, ((o1, o2) -> o1.cost - o2.cost));
		dp = new int[list.size()+1][K];
		for (int i = 1; i <= list.size(); i++) {
			for (int j = 0; j < K; j++) {
				if (list.get(i - 1).cost > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j - list.get(i - 1).cost] + list.get(i - 1).value, dp[i - 1][j]);
				}
			}
		}
		System.out.println(dp[list.size()][K - 1]);
	}

	static int dfs(int cur) {
		int amount = candies[cur];
		visited[cur] = true;
		cnt++;
		for (int nxt : friends[cur]) {
			if (!visited[nxt]) {
				amount += dfs(nxt);
			}
		}
		return amount;
	}
}
class Node	{
	int cost, value;

	public Node(int cost, int value) {
		this.cost = cost;
		this.value = value;
	}
}