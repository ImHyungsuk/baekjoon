import java.util.*;
import java.io.*;

public class Main {
	static int N = 0;
	static ArrayList<Integer> arr = new ArrayList<>();
	static int[][][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		while (st.hasMoreTokens()) {
			arr.add(Integer.parseInt(st.nextToken()));
			N++;
		}
		dp = new int[N][5][5];
		dp[0][0][0] = 0;
		int ans = Solution(0, 0, 0);
		System.out.println(ans);
	}

	static int Solution(int turn, int left, int right) {
		if (turn == arr.size() - 1) {
			return 0;
		}
		if (dp[turn][left][right] != 0) {
			return dp[turn][left][right];
		}
		int nxt = arr.get(turn);
		int l, r;
		if (left != 0) {
			if (left - nxt == 2 || left - nxt == -2) {
				l = 4;
			} else if (nxt == left) {
				l = 1;
			} else
				l = 3;
		} else
			l = 2;
		if (right != 0) {
			if (right - nxt == 2 || right - nxt == -2) {
				r = 4;
			} else if (nxt == right) {
				r = 1;
			} else
				r = 3;
		} else
			r = 2;
		dp[turn][left][right] = Math.min(Solution(turn + 1, nxt, right) + l, Solution(turn + 1, left, nxt) + r);
		return dp[turn][left][right];
	}
}