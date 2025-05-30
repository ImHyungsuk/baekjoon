import java.util.*;
import java.io.*;

public class Main {
	static int r, c, t;
	static int[][] map;
	static Queue<Location> dust_q;
	static ArrayList<Location> clean_arr;
	static int[] nx_x = {-1, 1, 0, 0}, nx_y = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		dust_q = new ArrayDeque<>();
		clean_arr = new ArrayList<>();
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0) {
					dust_q.add(new Location(j, i, map[i][j]));
				} else if (map[i][j] == -1) {
					clean_arr.add(new Location(j, i, map[i][j]));
				}
			}
		}
		for (int i = 0; i < t; i++) {
			diffuseDust();
			wind();
			getDust();
		}
		int cnt = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] > 0) {
					cnt += map[i][j];
				}
			}
		}
		System.out.println(cnt);
	}

	static void diffuseDust() {
		while (!dust_q.isEmpty()) {
			Location dust = dust_q.poll();
			for (int i = 0; i < 4; i++) {
				int next_x = nx_x[i] + dust.x;
				int next_y = nx_y[i] + dust.y;
				int dust_amount = dust.amount / 5;
				if (next_y < 0 || next_y >= r || next_x < 0 || next_x >= c || map[next_y][next_x] == -1) {
					continue;
				}
				map[next_y][next_x] += dust_amount;
				map[dust.y][dust.x] -= dust_amount;
			}
		}
	}

	static void wind() {
		Location clean = clean_arr.get(0);
		for (int y = clean.y - 2; y >= 0; y--) {
			map[y + 1][0] = map[y][0];
		}
		for (int x = 1; x < c; x++) {
			map[0][x - 1] = map[0][x];
		}
		for (int y = 1; y <= clean.y; y++) {
			map[y - 1][c - 1] = map[y][c - 1];
		}
		for (int x = c - 2; x > 0; x--) {
			map[clean.y][x + 1] = map[clean.y][x];
		}
		map[clean.y][1] = 0;
		clean = clean_arr.get(1);
		for (int y = clean.y + 2; y < r; y++) {
			map[y - 1][0] = map[y][0];
		}
		for (int x = 1; x < c; x++) {
			map[r - 1][x - 1] = map[r - 1][x];
		}
		for (int y = r - 2; y >= clean.y; y--) {
			map[y + 1][c - 1] = map[y][c - 1];
		}
		for (int x = c - 2; x > 0; x--) {
			map[clean.y][x + 1] = map[clean.y][x];
		}
		map[clean.y][1] = 0;
	}

	static void getDust() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] > 0) {
					dust_q.add(new Location(j, i, map[i][j]));
				}
			}
		}
	}

	static class Location {
		int x;
		int y;
		int amount;

		public Location(int x, int y, int amount) {
			this.x = x;
			this.y = y;
			this.amount = amount;
		}
	}
}