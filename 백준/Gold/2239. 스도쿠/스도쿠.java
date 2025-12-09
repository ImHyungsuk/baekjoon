import java.util.*;
import java.io.*;

public class Main {
	static int[][] sudoku = new int[9][9];
	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			char[] chars = br.readLine().toCharArray();
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = chars[j] - '0';
			}
		}
		dfs(0);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(sudoku[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void dfs(int depth) {
		if (depth == 81) {
			flag = true;
			return;
		}
		int y = depth / 9;
		int x = depth % 9;
		if (sudoku[y][x] != 0) {
			dfs(depth + 1);
		} else {
			for (int i = 1; i <= 9; i++) {
				if (!isValid(x, y, i))
					continue;
				sudoku[y][x] = i;
				dfs(depth + 1);
				if (flag)
					return;
				sudoku[y][x] = 0;
			}
		}
	}

	static boolean isValid(int x, int y, int value) {
		for (int i = 0; i < 9; i++) {
			if (sudoku[y][i] == value) {
				return false;
			}
			if (sudoku[i][x] == value) {
				return false;
			}
		}
		int tmp1 = (y / 3) * 3;
		int tmp2 = (x / 3) * 3;
		for (int i = tmp1; i < tmp1 + 3; i++) {
			for (int j = tmp2; j < tmp2 + 3; j++) {
				if (sudoku[i][j] == value) {
					return false;
				}
			}
		}
		return true;
	}
}