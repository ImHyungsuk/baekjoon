import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int[] dp, A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		dp = new int[n];
		A = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, recur(i));
		}
		System.out.println(max);
	}

	static int recur(int idx) {
		if (dp[idx] == 0) {
			dp[idx] = 1;

			for (int i = idx + 1; i < n; i++) {
				if (A[idx] > A[i]) {
					dp[idx] = Math.max(dp[idx], recur(i) + 1);
				}
			}
		}
		return dp[idx];
	}
}
