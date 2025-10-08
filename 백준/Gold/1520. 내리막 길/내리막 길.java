import java.sql.Struct;
import java.util.*;
import java.io.*;

public class Main {
	static int M, N;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] map, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		dp = new int[M][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		System.out.println(dfs(0, 0));
		// for (int i = 0; i < M; i++) {
		// 	for (int j = 0; j < N; j++)
		// 		System.out.print(dp[i][j] + " ");
		// 	System.out.print("\n");
		// }
	}

	static int dfs(int x, int y) {
		if (y == M - 1 && x == N - 1)
			return 1;
		if (dp[y][x] != -1)
			return dp[y][x];
		dp[y][x] = 0;
		for (int i = 0; i < 4; i++) {
			int nx_x = x + dx[i];
			int nx_y = y + dy[i];
			if (nx_x < 0 || nx_x >= N || nx_y < 0 || nx_y >= M) {
				continue;
			}
			if (map[nx_y][nx_x] < map[y][x]) {
				dp[y][x] += dfs(nx_x, nx_y);
				// System.out.println(y + " " + x + " " + dp[y][x] + "\n");
			}
		}
		return dp[y][x];
	}
}