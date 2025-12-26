import java.io.*;
import java.util.*;

public class Main {
	static int N, mod = 1_000_000_000;
	static long[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		dp = new long[N + 1][10][1 << 10];
		for (int i = 1; i < 10; i++) {
			dp[1][i][1 << i] = 1;
		}

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 1024; k++) {
					int bit = k | (1 << j);
					if (j == 0) {
						dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j + 1][k]) % mod;
					} else if (j == 9) {
						dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j - 1][k]) % mod;
					} else {
						dp[i][j][bit] = (dp[i][j][bit] + dp[i - 1][j - 1][k] + dp[i - 1][j + 1][k]) % mod;
					}
				}
			}
		}

		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum = (sum + dp[N][i][1023]) % mod;
		}
		System.out.println(sum);
	}
}