import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static List<Integer>[] lists;
	static int[] rank;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lists = new List[N + 1];
		rank = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			lists[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			lists[a].add(b);
			rank[b]++;
		}
		bfs();
		System.out.println(sb);
	}

	static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (rank[i] == 0) {
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			for (int nxt : lists[cur]) {
				rank[nxt]--;
				if (rank[nxt] == 0) {
					q.add(nxt);
				}
			}
		}
	}
}