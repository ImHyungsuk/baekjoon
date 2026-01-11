import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static ArrayList<Integer> arr = new ArrayList<>();
	static int[][] weight = {
		{1, 2, 2, 2, 2},
		{0, 1, 3, 4, 3},
		{0, 3, 1, 3, 4},
		{0, 4, 3, 1, 3},
		{0, 3, 4, 3, 1}
	};
	static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		while (st.hasMoreElements()) {
			int n = Integer.parseInt(st.nextToken());
			if (n == 0)
				break;
			arr.add(n);
		}
		N = arr.size();
		dp = new int[N][5][5];
		int ans = search(0, 0, 0);
		System.out.println(ans);
	}

	static int search(int idx, int l, int r) {
		if (idx == N) {
			return 0;
		}
		if (dp[idx][l][r] != 0) {
			return dp[idx][l][r];
		}
		int nxt = arr.get(idx);
		dp[idx][l][r] = Math.min(search(idx + 1, nxt, r) + weight[l][nxt], search(idx + 1, l, nxt) + weight[r][nxt]);
		return dp[idx][l][r];
	}
}