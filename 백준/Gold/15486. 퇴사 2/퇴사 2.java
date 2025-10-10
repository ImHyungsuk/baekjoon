import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		dp = new int[n + 1];
		int max = -1;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int end = t + i - 1;
			max = Math.max(max, dp[i - 1]);
			if (end <= n) {
				dp[end] = Math.max(dp[end], max + p);
			}
		}
		for (int i = 1; i <= n; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}
