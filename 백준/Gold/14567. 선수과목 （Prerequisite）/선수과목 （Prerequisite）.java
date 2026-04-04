import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] next;
	static int[] pres;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		next = new ArrayList[N + 1];
		pres = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			next[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			next[a].add(b);
			pres[b]++;
		}

		boolean[] visited = new boolean[N + 1];
		int cnt = 0,semes=0;
		int[] answer = new int[N + 1];
		// for (int i = 1; i <= N; i++) {
		// 	if (!visited[i] && pres[i] == 0) {
		// 		pq.add(new Lecture(i, 1));
		// 		visited[i] = true;
		// 	}
		// }
		while (cnt < N) {
			semes++;
			Queue<Lecture> q = new ArrayDeque<>();
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && pres[i] == 0) {
					visited[i] = true;
					q.add(new Lecture(i, semes));
				}
			}
			while (!q.isEmpty()) {
				Lecture cur = q.poll();
				cnt++;
				for (int nxt : next[cur.num]) {
					pres[nxt]--;
				}
				answer[cur.num] = semes;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb);
	}
}

class Lecture implements Comparable<Lecture> {
	int num, semester;

	public Lecture(int num, int semester) {
		this.num = num;
		this.semester = semester;
	}

	@Override
	public int compareTo(Lecture l) {
		return this.semester - l.semester;
	}
}