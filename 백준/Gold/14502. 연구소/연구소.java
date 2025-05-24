import java.util.*;
import java.io.*;

public class Main {
	static int N, M, new_wall_cnt = 3, max = 0;
	static int wall_cnt = 0, virus_cnt = 0;
	static int[][] lab, lab_copy;
	static int[] x_nx = {-1, 1, 0, 0}, y_nx = {0, 0, -1, 1};
	static ArrayList<Location> virusList;

	static int[][] log;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		virusList = new ArrayList<>();
		lab = new int[N][M];
		log = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				if (lab[i][j] == 2) {
					virusList.add(new Location(j, i));
				} else if (lab[i][j] == 1)
					wall_cnt++;
			}
		}
		solve();
		System.out.println(max);

		// for (int i = 0; i < N; i++) {
		// 	for (int j = 0; j < M; j++) {
		// 		sb.append(log[i][j]).append(" ");
		// 	}
		// 	sb.append("\n");
		// }
		// System.out.println(sb);
	}

	static void solve() {
		wall_dfs(0);
	}

	static void wall_dfs(int start) {
		if (new_wall_cnt == 0) {
			labInit();
			virus_bfs();
			countSafe();
			return;
		}
		for (int i = start; i < M * N; i++) {
			int x = i % M;
			int y = i / M;
			if (lab[y][x] == 0) {
				new_wall_cnt--;
				wall_cnt++;
				lab[y][x] = 1;
				wall_dfs(start + 1);
				lab[y][x] = 0;
				new_wall_cnt++;
				wall_cnt--;
			}
		}
	}

	static void virus_bfs() {
		Queue<Location> virus_q = new ArrayDeque<>();
		for (int i = 0; i < virusList.size(); i++) {
			virus_q.add(virusList.get(i));
		}
		virus_cnt = virusList.size();
		while (!virus_q.isEmpty()) {
			Location cur_loc = virus_q.poll();
			for (int i = 0; i < 4; i++) {
				int next_x = cur_loc.x + x_nx[i];
				int next_y = cur_loc.y + y_nx[i];
				if (next_x < 0 || next_x >= M || next_y < 0 || next_y >= N ||
					lab_copy[next_y][next_x] == 2 || lab_copy[next_y][next_x] == 1) {
					continue;
				}
				if (lab_copy[next_y][next_x] == 0) {
					lab_copy[next_y][next_x] = 2;
					virus_cnt++;
					virus_q.add(new Location(next_x, next_y));
				}
			}
		}
	}

	static void labInit() {
		lab_copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				lab_copy[i][j] = lab[i][j];
			}
		}
	}

	static void countSafe() {
		int cnt = N * M - virus_cnt - wall_cnt;
		if (max < cnt) {
			max = cnt;
			log = lab_copy;
		}
	}
}

class Location {
	int x;
	int y;

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}