import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] pre;
	static ArrayList<Integer>[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pre = new int[N + 1];
		arr = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int cnt = Integer.parseInt(st.nextToken());
			int prev = Integer.parseInt(st.nextToken());
			for (int j = 1; j < cnt; j++) {
				int cur = Integer.parseInt(st.nextToken());
				arr[prev].add(cur);
				pre[cur]++;
				prev = cur;
			}
		}
		Queue<Integer> q = new ArrayDeque<>();
		// System.out.println(Arrays.toString(pre));
		for (int i = 1; i <= N; i++) {
			if (pre[i] == 0) {
				q.add(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		int cnt = N;
		while (!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append("\n");
			cnt--;
			for (int nxt : arr[cur]) {
				pre[nxt]--;
				// System.out.println(cur + " " + nxt + ": " + pre[nxt]);
				if (pre[nxt] == 0) {
					q.add(nxt);
				}
			}
		}
		// System.out.println("cnt: " + cnt);
		if (cnt == 0) {
			System.out.println(sb);
		} else {
			System.out.println(0);
		}
	}
}