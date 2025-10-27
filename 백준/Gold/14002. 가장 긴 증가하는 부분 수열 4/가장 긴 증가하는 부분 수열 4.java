import java.util.*;
import java.io.*;

public class Main {
	static int N, max;
	static int[] arr, dp, lis, next;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		dp = new int[N];
		lis = new int[N];
		next = new int[N];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = N - 1; i >= 0; i--) {
			int tmp = recur(i);
			if (max < tmp) {
				max = tmp;
				getLIS(i, max);
			}
		}
		System.out.println(max);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < max; i++) {
			sb.append(lis[i]).append(" ");
		}
		System.out.println(sb);
		// System.out.println(Arrays.toString(dp));
		// System.out.println(Arrays.toString(next));
	}

	static int recur(int idx) {
		if (dp[idx] == 0) {
			dp[idx] = 1;
			for (int i = idx - 1; i >= 0; i--) {
				if (arr[i] < arr[idx]) {
					int tmp = recur(i) + 1;
					if (tmp > dp[idx]) {
						dp[idx] = tmp;
						next[idx] = i;
						// System.out.println(idx + " next " + next[idx]);
					}
				}
			}
		}
		if (dp[idx] == 1) {
			next[idx] = -1;
		}

		return dp[idx];
	}

	static void getLIS(int cur, int max) {
		int idx = max - 1;
		while (cur != -1) {
			lis[idx] = arr[cur];
			cur = next[cur];
			idx--;
		}
	}
}