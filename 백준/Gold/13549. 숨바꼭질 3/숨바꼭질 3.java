import java.util.*;
import java.io.*;

public class Main {
	static int N, K, ret;
	static int[] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[100001];
		Arrays.fill(map, 98765432);
		if (N >= K) {
			System.out.println(N - K);
			return;
		}
		bfs();
		sb.append(ret);
		System.out.println(sb);
	}

	static void bfs() {
		PriorityQueue<Location> pq = new PriorityQueue<>();
		pq.add(new Location(N, 0));
		map[N] = 0;
		while (!pq.isEmpty()) {
			Location cur = pq.poll();
			if (cur.idx == K) {
				ret = cur.time;
				return;
			}
			if (map[cur.idx] < cur.time)
				continue;
			for (int i = 0; i < 3; i++) {
				int next;
				if (i == 0) {
					next = 2 * cur.idx;
				} else if (i == 1) {
					next = cur.idx + 1;
				} else {
					next = cur.idx - 1;
				}
				if (next < 0 || next > 100000) {
					continue;
				}
				if (i == 0) {
					if (map[next] > cur.time) {
						map[next] = cur.time;
						pq.add(new Location(next, cur.time));
					}
				} else {
					if (map[next] > cur.time + 1) {
						map[next] = cur.time + 1;
						pq.add(new Location(next, cur.time + 1));
					}
				}
			}
		}
	}

	static class Location implements Comparable<Location> {
		int idx;
		int time;

		public Location(int idx, int time) {
			this.idx = idx;
			this.time = time;
		}

		@Override
		public int compareTo(Location location) {
			return this.time - location.time;
		}
	}
}