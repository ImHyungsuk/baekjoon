import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		ArrayList<Node>[] map = new ArrayList[n + 1];
		int[] dist = new int[n + 1];
		int[] route = new int[n + 1];
		boolean[] visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			map[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			map[start].add(new Node(end, cost));
		}
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		dijkstra(start, end, map, dist, route, visited);
		System.out.println(dist[end]);
		int idx = end;
		ArrayList<Integer> routes = new ArrayList<>();
		while (idx != 0) {
			routes.add(idx);
			idx = route[idx];
		}
		System.out.println(routes.size());
		StringBuilder sb = new StringBuilder();
		for (int i = routes.size() - 1; i >= 0; i--) {
			sb.append(routes.get(i)).append(" ");
		}
		System.out.println(sb);
	}

	static void dijkstra(int start, int end, ArrayList<Node>[] map, int[] dist, int[] route, boolean[] visited) {
		Arrays.fill(dist, 100000001);
		dist[0] = 0;
		route[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int cur_index = cur.index;
			int cur_cost = cur.cost;
			if (dist[cur_index] < cur_cost) {
				continue;
			}
			if (visited[cur_index]) {
				continue;
			}
			visited[cur_index] = true;
			for (int i = 0; i < map[cur_index].size(); i++) {
				Node next = map[cur_index].get(i);
				int next_cost = cur_cost + next.cost;
				if (!visited[next.index] && dist[next.index] > next_cost) {
					dist[next.index] = next_cost;
					pq.add(new Node(next.index, next_cost));
					route[next.index] = cur_index;
				}
			}
		}
	}
}

class Node implements Comparable<Node> {
	int index;
	int cost;

	Node(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
}