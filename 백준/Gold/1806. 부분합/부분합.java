import java.util.*;
import java.io.*;

public class Main {
	static int[] dp, arr;
	static int length = Integer.MAX_VALUE, N, S;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		dp = new int[N + 1];
		arr = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = dp[i - 1] + arr[i];
		}
		int s = 0, e = 0, sum = 0;
		while (e < N + 1) {
			// System.out.println(dp[e] - dp[s] + " " + S);
			if (dp[e] - dp[s] >= S) {
				length = Math.min(length, e - s);
				s++;
			} else {
				e++;
			}
		}
		System.out.println(length == Integer.MAX_VALUE ? 0 : length);
	}
}