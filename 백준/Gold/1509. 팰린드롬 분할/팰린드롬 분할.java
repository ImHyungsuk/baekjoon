import java.util.*;
import java.io.*;

public class Main {
	static int[] dp;
	static boolean[][] isPalindrome;
	static String string;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		string = br.readLine();
		int len = string.length();
		dp = new int[len + 1];
		isPalindrome = new boolean[len + 1][len + 1];
		checkPalindrome(len);
		Arrays.fill(dp, Integer.MAX_VALUE-1);
		dp[0] = 0;

		for (int i = 1; i <= len; i++) {
			for (int j = 1; j <= i; j++) {
				if (isPalindrome[j][i]) {
					dp[i] = Math.min(dp[j - 1] + 1, dp[i]);
				}
			}
		}
		System.out.println(dp[len]);
	}

	static void checkPalindrome(int len) {
		for (int start = 1; start <= len; start++) {
			for (int end = start; end <= len; end++) {
				boolean flag = true;
				int s = start - 1;
				int e = end - 1;
				while (s <= e) {
					if (string.charAt(s++) != string.charAt(e--)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					isPalindrome[start][end] = true;
				}
			}
		}
	}
}