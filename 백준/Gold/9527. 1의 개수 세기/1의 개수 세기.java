import java.util.*;
import java.io.*;

public class Main {
	static long A, B;
	static long[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		dp = new long[55];
		dp[0] = 1;
		for (int i = 1; i < 55; i++) {
			dp[i] = (dp[i - 1] << 1) + (1L << i);
		}
		long result = calOne(B) - calOne(A - 1);
		System.out.println(result);
	}

	static long calOne(long N) {
		long count = N & 1;
		int size = (int)(Math.log(N) / Math.log(2));

		for (int i = size; i > 0; i--) {
			if ((N & (1L << i)) != 0L) {
				count += dp[i - 1] + (N - (1L << i) + 1);
				N -= (1L << i);
			}
		}
		return count;
	}
}