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
			if (dp[i] == 0) {
				dp[i] = A[i];
			}
			for (int j = i + 1; j < n; j++) {
				if (A[j] > A[i]) {
					dp[j] = Math.max(dp[j], dp[i] + A[j]);
				}
			}
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
	}
}
