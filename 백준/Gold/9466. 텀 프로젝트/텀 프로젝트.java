import java.io.*;
import java.util.*;

public class Main {
	static int T, N, cnt;
	static int[] next;
	static boolean[] isSearchEnd, visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(st.nextToken());
		int ans = 0;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			next = new int[N + 1];
			isSearchEnd = new boolean[N + 1];
			visited = new boolean[N + 1];
			for (int j = 1; j <= N; j++) {
				next[j] = Integer.parseInt(st.nextToken());
			}
			cnt = 0;
			for (int j = 1; j <= N; j++) {
				dfs(j);
			}
			sb.append(N - cnt).append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int cur) {
		visited[cur] = true;
		int nxt = next[cur];
		if (!visited[nxt]) {
			dfs(nxt);
		} else {
			if (!isSearchEnd[nxt]) {
				cnt++;
				while (nxt != cur) {
					cnt++;
					nxt = next[nxt];
				}
			}
		}
		isSearchEnd[cur] = true;
	}
}