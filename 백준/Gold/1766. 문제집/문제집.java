import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] pres;
	static boolean[] visited;
	static ArrayList<Integer>[] next;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pres = new int[N + 1];
		next = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			next[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			next[a].add(b);
			pres[b]++;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			if (pres[i] == 0) {
				pq.add(i);
			}
		}
		visited = new boolean[N + 1];
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			int cur = pq.poll();
			visited[cur] = true;
			for (int nxt : next[cur]) {
				pres[nxt]--;
				if (pres[nxt] == 0 && !visited[nxt]) {
					pq.add(nxt);
				}
			}
			sb.append(cur).append(" ");
		}
		System.out.println(sb);
	}
}