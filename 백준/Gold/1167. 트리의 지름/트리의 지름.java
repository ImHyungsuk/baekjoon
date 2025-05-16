
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int V, max_cost = 0, max_node = 0;
	static ArrayList<Node>[] edges;
	static int[] dist;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());

		edges = new ArrayList[V + 1];
		for (int i = 0; i <= V; i++) {
			edges[i] = new ArrayList<Node>();
		}
		visited = new boolean[V + 1];
		dist = new int[V + 1];

		int start, end, cost;
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			while (true) {
				end = Integer.parseInt(st.nextToken());
				if (end == -1) {
					break;
				}
				cost = Integer.parseInt(st.nextToken());
				edges[start].add(new Node(end, cost));
			}
		}
		bfs(1);
		max_cost = 0;
		visited = new boolean[V + 1];
		dist = new int[V + 1];
		bfs(max_node);
		System.out.println(max_cost);
	}

	public static void bfs(int start) {
		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(start, 0));
		dist[start] = 0;
		visited[start] = true;
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 0; i < edges[cur.end].size(); i++) {
				int next_node = edges[cur.end].get(i).end;
				int next_cost = edges[cur.end].get(i).cost + cur.cost;
				if(visited[next_node])
					continue;
				visited[next_node] = true;
				dist[next_node] = next_cost;
				q.add(new Node(next_node, next_cost));
			}
		}
		for (int i = 1; i <= V; i++) {
			if (max_cost < dist[i]) {
				max_node = i;
				max_cost = dist[i];
			}
		}
	}

	public static class Node {
		int end, cost;

		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}
	}
}