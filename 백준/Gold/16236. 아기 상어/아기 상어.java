import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = {-1, 0, 0, 1};
	static int[] dx = {0, -1, 1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				map[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		Solution(map, n);
	}

	static void Solution(int[][] map, int n) {
		int x = 0, y = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[j][i] == 9) {
					x = j;
					y = i;
					map[j][i] = 0;
				}
			}
		}
		Shark shark = new Shark();

		while (true) {
			PriorityQueue<Fish> pq = new PriorityQueue<>((f1, f2) ->
				f1.dist != f2.dist ? f1.dist - f2.dist : (f1.y != f2.y ? f1.y - f2.y : f1.x - f2.x)
			);
			pq.add(new Fish(x, y, 0));
			boolean isEat = false;
			boolean[][] visit = new boolean[n][n];
			visit[x][y] = true;

			while (!pq.isEmpty()) {
				Fish cur = pq.poll();

				if (map[cur.x][cur.y] != 0 && map[cur.x][cur.y] < shark.size) {
					map[cur.x][cur.y] = 0;
					shark.eat(cur.dist);
					x = cur.x;
					y = cur.y;
					isEat = true;
					// System.out.println(x + " " + y + " " + shark.time);
					break;
				}
				for (int i = 0; i < 4; i++) {
					int ny = cur.y + dy[i];
					int nx = cur.x + dx[i];
					if (ny < 0 || ny >= n || nx < 0 || nx >= n || visit[nx][ny] || map[nx][ny] > shark.size) {
						continue;
					}
					pq.add(new Fish(nx, ny, cur.dist + 1));
					visit[nx][ny] = true;
				}
			}
			if (!isEat)
				break;
		}

		System.out.println(shark.time);
	}

}

class Fish {
	int x, y;
	int dist;

	Fish(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}

class Shark {
	int food;
	int size;
	int time;

	Shark() {
		this.food = 0;
		this.size = 2;
		this.time = 0;
	}

	void eat(int dist) {
		this.food++;
		if (this.food == this.size) {
			increase();
		}
		this.time += dist;
	}

	private void increase() {
		this.size++;
		this.food = 0;
	}
}