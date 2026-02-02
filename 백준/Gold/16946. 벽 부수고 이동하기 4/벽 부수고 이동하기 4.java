import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static int[][] map, group;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static HashMap<Integer, Integer> hashMap = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		group = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		int groupCnt = 1;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (map[y][x] == 0 && group[y][x] == 0) {
					hashMap.put(groupCnt, dfs(y, x, groupCnt));
					groupCnt++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (group[y][x] == 0) {
					sb.append(count(y, x));
				} else
					sb.append(0);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	static int count(int y, int x) {
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
		for (int s : set) {
			cnt += hashMap.get(s);
		}
		return cnt % 10;
	}

	static int dfs(int y, int x, int index) {
		int cnt = 1;
		group[y][x] = index;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || nx < 0 || ny >= N || nx >= M) {
				continue;
			}
			if (group[ny][nx] == 0 && map[ny][nx] == 0) {
				group[ny][nx] = index;
				cnt += dfs(ny, nx, index);
			}
		}
		return cnt;
	}
}