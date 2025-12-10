import java.io.*;
import java.util.*;

public class Main {
	static int[][] dp;
	static String str1, str2;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str1 = br.readLine();
		str2 = br.readLine();
		int len1 = str1.length();
		int len2 = str2.length();
		dp = new int[len1 + 1][len2 + 1];
		for (int i = 1; i < len1 + 1; i++) {
			for (int j = 1; j < len2 + 1; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		int i = len1;
		int j = len2;
		Stack<Character> st = new Stack<>();
		while (i > 0 && j > 0) {
			if (dp[i][j] == dp[i - 1][j]) {
				i--;
			} else if (dp[i][j] == dp[i][j - 1]) {
				j--;
			} else {
				st.push(str1.charAt(i - 1));
				// System.out.println("push: " + str1.charAt(i - 1) + " " + (i - 1));
				i--;
				j--;
			}
		}
		while (!st.isEmpty()) {
			sb.append(st.pop());
		}

		System.out.println(dp[len1][len2]);
		System.out.println(sb);
	}

}