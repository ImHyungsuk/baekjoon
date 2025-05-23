import java.util.*;
import java.io.*;

public class Main {
	static int N, K, cnt = 0, minTime = 98765432;
	static int[] time = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Arrays.fill(time, 98766543);

		if (N >= K) {
			System.out.println(N - K + "\n" + 1);
			return;
		}

		bfs();
		System.out.println(time[K] + "\n" + cnt);
	}

	static void bfs() {
		Queue<Location> q = new ArrayDeque<>();
		q.add(new Location(N, 0));
		time[N] = 0;
		while (!q.isEmpty()) {
			Location now = q.poll();
			if (now.idx == K) {
				if (now.cnt < minTime) {
					cnt = 1;
					minTime = now.cnt;
				}else {
					cnt++;
				}
				continue;
			}
			for (int i = 0; i < 3; i++) {
				int next;
				if (i == 0)
					next = now.idx - 1;
				else if (i == 1) {
					next = now.idx + 1;
				} else {
					next = now.idx * 2;
				}
				if (next < 0 || next > 100000) {
					continue;
				}
				if (time[next] >= time[now.idx] + 1) {
					time[next] = time[now.idx] + 1;
					q.add(new Location(next, time[next]));
				}
			}
		}
	}

	static class Location {
		int idx;
		int cnt;

		public Location(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
	}
}