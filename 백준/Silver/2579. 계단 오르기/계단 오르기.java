import java.util.*;
import java.io.*;

public class Main {
	static int[] stairs, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		stairs = new int[N];
		dp = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			stairs[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = stairs[0];
		if (N > 1) {
			dp[1] = dp[0] + stairs[1];
			if (N > 2) {
				dp[2] = Math.max(stairs[0], stairs[1]) + stairs[2];
				for (int i = 3; i < N; i++) {
					dp[i] = Math.max(dp[i - 2], dp[i - 3] + stairs[i - 1]) + stairs[i];
				}
			}
		}
		System.out.println(dp[N - 1]);
	}
}