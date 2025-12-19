import java.io.*;
import java.util.*;

public class Main {
	static int[][] words;
	static char[] a, b;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st1 = br.readLine();
		String st2 = br.readLine();
		int n1 = st1.length();
		int n2 = st2.length();
		a = new char[n1];
		b = new char[n2];
		for (int i = 0; i < n1; i++) {
			a[i] = st1.charAt(i);
		}
		for (int i = 0; i < n2; i++) {
			b[i] = st2.charAt(i);
		}
		words = new int[n1 + 1][n2 + 1];

		for (int i = 0; i < n1; i++) {
			for (int j = 0; j < n2; j++) {
				if (a[i] == b[j]) {
					words[i + 1][j + 1] = words[i][j] + 1;
				} else {
					words[i + 1][j + 1] = Math.max(words[i][j + 1], words[i + 1][j]);
				}
			}
		}
		// for (int i = 0; i < n1 + 1; i++) {
		// 	for (int j = 0; j < n2 + 1; j++) {
		// 		System.out.print(words[i][j]);
		// 	}
		// 	System.out.println();
		// }

		Stack<Character> st = new Stack<>();
		int i = n1, j = n2;
		while (words[i][j] > 0) {
			if (words[i][j] == words[i][j - 1]) {
				j--;
			} else if (words[i][j] == words[i - 1][j]) {
				i--;
			} else {
				st.push(b[j - 1]);
				i--;
				j--;
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!st.empty()) {
			sb.append(st.pop());
		}
		System.out.println(words[n1][n2]);
		System.out.println(sb);
	}
}