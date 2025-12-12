import java.util.*;
import java.io.*;

public class Main {
	static int N, min;
	static int[][] colors, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		colors = new int[N + 1][3];
		dp = new int[N + 1][3];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			colors[i][0] = Integer.parseInt(st.nextToken());
			colors[i][1] = Integer.parseInt(st.nextToken());
			colors[i][2] = Integer.parseInt(st.nextToken());
		}
		min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			Solution(i);
			min = Math.min(min, dp[1][i]);
		}
		System.out.println(min);
	}

	static void Solution(int start) {
		for (int i = 0; i < 3; i++) {
			if (start == i) {
				dp[N][i] = 100001;
				continue;
			}
			dp[N][i] = colors[N][i];
		}
		for (int i = N - 1; i > 0; i--) {
			dp[i][0] = Math.min(dp[i + 1][1], dp[i + 1][2]) + colors[i][0];
			dp[i][1] = Math.min(dp[i + 1][0], dp[i + 1][2]) + colors[i][1];
			dp[i][2] = Math.min(dp[i + 1][1], dp[i + 1][0]) + colors[i][2];
		}
	}
}