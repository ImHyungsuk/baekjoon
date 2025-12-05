import java.util.*;
import java.io.*;

public class Main {
	static int[][] dp;
	static int N, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		dp = new int[N + 1][K + 1];
		Arrays.fill(dp[0], 1);
		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < K + 1; j++) {
				long tmp = dp[i - 1][j] + dp[i][j - 1];
				dp[i][j] = (int)(tmp % 1000000000);
			}
		}

		System.out.println(dp[N][K]);
	}
}