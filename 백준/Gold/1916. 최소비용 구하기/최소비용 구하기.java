import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static ArrayList<Node>[] next;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		next = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			next[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			next[s].add(new Node(e, Integer.parseInt(st.nextToken())));
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		System.out.println(dijkstra(s, e));
	}

	static int dijkstra(int s, int e) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1];
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		pq.add(new Node(s, 0));
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int cur_num = cur.num;

			if (!visited[cur_num]) {
				visited[cur_num] = true;

				for (Node nxt : next[cur_num]) {
					if (!visited[nxt.num] && dist[nxt.num] > dist[cur_num] + nxt.weight) {
						dist[nxt.num] = dist[cur_num] + nxt.weight;
						pq.add(new Node(nxt.num, dist[nxt.num]));
					}
				}
			}
		}
		return dist[e];
	}
}

class Node implements Comparable<Node> {
	int num, weight;

	public Node(int num, int weight) {
		this.num = num;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node node) {
		return this.weight - node.weight;
	}
}