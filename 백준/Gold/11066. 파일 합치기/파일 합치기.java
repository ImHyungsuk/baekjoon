import java.io.*;
import java.util.*;

public class Main {
	static int T, N;
	static int[] nums, sums;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			nums = new int[N + 1];
			sums = new int[N + 1];
			Arrays.fill(nums, 0);
			Arrays.fill(sums, 0);
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j < N + 1; j++) {
				nums[j] = Integer.parseInt(st.nextToken());
				sums[j] = nums[j] + sums[j - 1];
			}
			dp = new int[N + 1][N + 1];
			for (int gap = 1; gap < N; gap++) {
				for (int start = 1; start + gap < N + 1; start++) {
					int end = start + gap;
					dp[start][end] = Integer.MAX_VALUE;
					for (int mid = start; mid < end; mid++) {
						dp[start][end] = Math.min(dp[start][end],
							dp[start][mid] + dp[mid + 1][end] + sums[end] - sums[start - 1]);
					}
				}
			}
			sb.append(dp[1][N]).append("\n");
		}
		System.out.println(sb);
	}

}