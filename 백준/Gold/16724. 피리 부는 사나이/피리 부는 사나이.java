import java.util.*;
import java.io.*;

public class Main {
	static int N, M, cnt = 0;
	static char[][] map;
	static boolean[][] isVisited, isSearchEnd;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		isVisited = new boolean[N][M];
		isSearchEnd = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = new StringTokenizer(br.readLine()).nextToken();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dfs(j, i);
			}
		}
		System.out.println(cnt);
	}

	static void dfs(int x, int y) {
		isVisited[y][x] = true;
		int x_new = x, y_new = y;
		if (map[y][x] == 'D') {
			y_new++;
		} else if (map[y][x] == 'U') {
			y_new--;
		} else if (map[y][x] == 'L') {
			x_new--;
		} else {
			x_new++;
		}
		if (isVisited[y_new][x_new]) {
			if (!isSearchEnd[y_new][x_new]) {
				cnt++;
			}
		} else {
			dfs(x_new, y_new);
		}
		isSearchEnd[y][x] = true;
	}
}