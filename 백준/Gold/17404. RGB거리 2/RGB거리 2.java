import java.io.*;
import java.util.*;

public class Main {
	static int[][] cost, dp;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		cost = new int[N][3];
		dp = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++) {
				if (k == i) {
					dp[0][k] = Integer.MAX_VALUE;
				} else
					dp[0][k] = cost[N - 1][i] + cost[0][k];
			}
			for (int j = 1; j < N - 1; j++) {
				dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + cost[j][0];
				dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + cost[j][1];
				dp[j][2] = Math.min(dp[j - 1][1], dp[j - 1][0]) + cost[j][2];
			}
			for (int k = 0; k < 3; k++) {
				if (k == i) {
					continue;
				}
				min = Math.min(min, dp[N - 2][k]);
			}
		}
		System.out.println(min);
	}
}