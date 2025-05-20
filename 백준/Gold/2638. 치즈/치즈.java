import java.util.*;
import java.io.*;

public class Main {
	static int N, M, res;
	static int[][] m;
	static boolean[][] visited;
	static int[] x_dir = {-1, 1, 0, 0};
	static int[] y_dir = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Queue<Dot> dot_arr = new ArrayDeque<>();

		m = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				m[i][j] = Integer.parseInt(st.nextToken());
				if (m[i][j] == 1) {
					dot_arr.add(new Dot(j, i));
					res++;
				}
			}
		}
		int time = 0;
		while (res > 0) {
			time++;
			visited = new boolean[N][M];
			findOut();
			melting(dot_arr);
		}
		System.out.println(time);
	}

	static void findOut() {
		Queue<Dot> q = new ArrayDeque<>();
		q.add(new Dot(0, 0));
		m[0][0] = 2;
		while (!q.isEmpty()) {
			int cur_x = q.peek().x;
			int cur_y = q.peek().y;
			q.poll();
			for (int i = 0; i < 4; i++) {
				int next_x = cur_x + x_dir[i];
				int next_y = cur_y + y_dir[i];
				if (next_x < 0 || next_x >= M || next_y < 0 || next_y >= N || visited[next_y][next_x]) {
					continue;
				}
				if (m[next_y][next_x] == 0 || m[next_y][next_x] == 2) {
					visited[next_y][next_x] = true;
					m[next_y][next_x] = 2;
					q.add(new Dot(next_x, next_y));
				}
			}
		}
	}

	static void melting(Queue<Dot> dot_arr) {
		int qSize = dot_arr.size();
		for (int i = 0; i < qSize; i++) {
			int x = dot_arr.peek().x;
			int y = dot_arr.peek().y;
			dot_arr.poll();
			int air_cnt = 0;
			for (int j = 0; j < 4; j++) {
				int nx_x = x + x_dir[j];
				int nx_y = y + y_dir[j];

				if (m[nx_y][nx_x] == 2) {
					air_cnt++;
				}
			}
			if (air_cnt < 2) {
				dot_arr.add(new Dot(x, y));
			} else {
				m[y][x] = 0;
				res--;
			}
		}
	}

	static class Dot {
		int x, y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}