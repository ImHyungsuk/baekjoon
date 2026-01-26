import java.util.*;
import java.io.*;

public class Main {
	static int len;
	static ArrayList<Integer> arr = new ArrayList<>();
	static int[][][] dp;
	static int[][] strength = {
		{0, 2, 2, 2, 2},
		{0, 1, 3, 4, 3},
		{0, 3, 1, 3, 4},
		{0, 4, 3, 1, 3},
		{0, 3, 4, 3, 1}
	};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		while (st.hasMoreElements()) {
			int tmp = Integer.parseInt(st.nextToken());
			if (tmp != 0)
				arr.add(tmp);
		}
		len = arr.size();
		dp = new int[5][5][len + 1];
		int ans = search(0, 0, 0);
		// System.out.println(dp[0][0][0]);
		System.out.println(ans);
	}

	static int search(int idx, int l, int r) {
		// System.out.println("idx: " + idx + " l: " + l + " r: " + r);
		if (idx == len) {
			// System.out.println("idx: " + idx + ", len: " + len);
			return 0;
		}
		if (dp[l][r][idx] != 0) {
			return dp[l][r][idx];
		}
		int nxt = arr.get(idx);
		dp[l][r][idx] = Math.min(search(idx + 1, nxt, r) + strength[l][nxt],
			search(idx + 1, l, nxt) + strength[r][nxt]);
		return dp[l][r][idx];
	}
}