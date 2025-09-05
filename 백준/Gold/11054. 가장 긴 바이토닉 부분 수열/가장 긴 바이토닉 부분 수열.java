import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] A, l_dp, r_dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int max = 0;
		N = Integer.parseInt(st.nextToken());
		A = new int[N];
		l_dp = new int[N];
		r_dp = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < A.length; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (A[i] > A[j]) {
					l_dp[i] = Math.max(l_dp[i], l_dp[j] + 1);
				}
			}
		}
		for (int i = N - 1; i >= 0; i--) {
			for (int j = N - 1; j > i; j--) {
				if (A[i] > A[j]) {
					r_dp[i] = Math.max(r_dp[i], r_dp[j] + 1);
				}
			}
		}
		for (int i = 0; i < N; i++) {
			int tmp = r_dp[i] + l_dp[i] + 1;
			max = Math.max(max, tmp);
		}
		System.out.println(max);
	}
}