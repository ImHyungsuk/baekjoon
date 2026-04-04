import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V, E, K;
	static ArrayList<Node>[] next;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		next = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			next[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			next[u].add(new Node(v, w));
		}

		dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dijkstra(K);
		StringBuilder sb = new StringBuilder();
		for (int i=1;i<=V;i++) {
			if (dist[i] == Integer.MAX_VALUE)
				sb.append("INF\n");
			else
				sb.append(dist[i]).append("\n");
		}
		System.out.println(sb);
	}

	static void dijkstra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V + 1];
		pq.add(new Node(s, 0));
		dist[s] = 0;
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int curNum = cur.num;
			if (!visited[curNum]) {
				visited[curNum] = true;
				for (Node nxt : next[curNum]) {
					if (!visited[nxt.num] && dist[nxt.num] > dist[curNum] + nxt.weight) {
						dist[nxt.num] = dist[curNum] + nxt.weight;
						pq.add(new Node(nxt.num, dist[nxt.num]));
					}
				}
			}
		}
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