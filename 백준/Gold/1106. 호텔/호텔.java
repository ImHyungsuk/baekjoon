import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] dp = new int[2000];
		Arrays.fill(dp,100000001);

		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int cost = Integer.parseInt(st.nextToken());
			int people = Integer.parseInt(st.nextToken());
			if (dp[people] > cost) {
				dp[people] = cost;
			}
			for (int j = people; j < c + 101; j++) {
				dp[j] = Math.min(dp[j - people] + cost, dp[j]);
			}
		}

		int result = Integer.MAX_VALUE;
		for (int i = c; i < c + 101; i++) {
			result = Math.min(result, dp[i]);
		}
		System.out.println(result);
	}
}