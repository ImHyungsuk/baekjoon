import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
	static int[][] map, group;
	static HashMap<Integer, Integer> groupSize = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		group = new int[N][M];
		int groupCnt = 1;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && group[i][j] == 0) {
					groupSize.put(groupCnt, bfs(j, i, groupCnt));
					groupCnt++;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (group[i][j] == 0) {
					sb.append(count(j, i));
				} else
					sb.append(0);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int count(int x, int y) {
		int cnt = 1;
		if (map[y][x] == 0) {
			return 0;
		}
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= M || ny >= N || group[ny][nx] == 0) {
				continue;
			}
			set.add(group[ny][nx]);
		}
		try {
			for (int s : set) {
				// System.out.println(s+"번째");
				cnt += groupSize.get(s);
			}
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			throw e;
		}
		return cnt % 10;
	}

	static int bfs(int x, int y, int index) {
		Queue<Point> q = new ArrayDeque<>();
		q.add(new Point(x, y));
		group[y][x] = index;
		int cnt = 1;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= M || ny >= N) {
					continue;
				}
				if (group[ny][nx] == 0 && map[ny][nx] == 0) {
					group[ny][nx] = index;
					cnt++;
					q.add(new Point(nx, ny));
				}
			}
		}
		return cnt;
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}