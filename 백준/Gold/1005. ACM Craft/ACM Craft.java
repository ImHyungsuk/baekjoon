import java.io.*;
import java.util.*;

public class Main {
	static int T, N, K, W;
	static int[] pre, time, dp;
	static ArrayList<Integer>[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Integer> q = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(st.nextToken());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			time = new int[N + 1];
			pre = new int[N + 1];
			dp = new int[N + 1];
			arr = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
				arr[i] = new ArrayList<>();
			}
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				arr[s].add(e);
				pre[e]++;
			}
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			for (int i = 1; i <= N; i++) {
				dp[i] = time[i];
				if (pre[i] == 0) {
					q.add(i);
				}
			}
			while (!q.isEmpty()) {
				int cur = q.poll();
				// System.out.println(cur+"시작");
				for (int nxt : arr[cur]) {
					dp[nxt] = Math.max(dp[nxt], dp[cur] + time[nxt]);
					pre[nxt]--;
					// System.out.println(cur + " -> " + nxt + " " + pre[nxt]);
					if (pre[nxt] == 0) {
						q.add(nxt);
					}
				}
			}
			sb.append(dp[W]).append("\n");
		}
		System.out.println(sb);
	}

}