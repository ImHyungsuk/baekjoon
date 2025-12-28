import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static boolean[] isNotPrime;
	static int[] num, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		isNotPrime = new boolean[N + 1];
		dp = new int[N + 1];
		isNotPrime[0] = true;
		isNotPrime[1] = true;
		int pre = 0;
		for (int i = 2; i <= N; i++) {
			if (isNotPrime[i])
				continue;
			dp[i] = pre + i;
			pre = dp[i];
			for (int j = 2; i * j <= N; j++) {
				isNotPrime[i * j] = true;
			}
		}
		int s = 1, e = 2, cnt = 0;
		while (s < N + 1 && e < N + 1) {
			if (dp[s] == 0 && s > 1) {
				s++;
				continue;
			}
			if (dp[e] == 0) {
				e++;
				continue;
			}
			if (dp[e] - dp[s] == N) {
				// System.out.println(s + " " + e);
				cnt++;
				e++;
			} else if (dp[e] - dp[s] < N)
				e++;
			else
				s++;
		}
		System.out.println(cnt);
	}
}