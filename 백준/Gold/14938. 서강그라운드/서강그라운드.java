import java.util.*;
import java.io.*;

public class Main {
	static int n, m, r;
	static int[] items;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		items = new int[n + 1];
		st = new StringTokenizer(br.readLine(), " ");
		map = new int[n + 1][n + 1];
		for (int i = 1; i < n + 1; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (map[s][e] == 0 || map[s][e] > c) {
				map[s][e] = c;
				map[e][s] = c;
			}
		}
		int max = 0;
		for (int i = 1; i < n + 1; i++) {
			int sum = dijkstra(i);
			max = Math.max(sum, max);
		}
		System.out.println(max);
	}

	static int dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
		int[] distance = new int[n + 1];
		Arrays.fill(distance, 9876543);
		pq.add(new Node(start, 0));
		distance[start] = 0;
		while (!pq.isEmpty()) {
			Node cur_node = pq.poll();
			if (cur_node.cost > distance[cur_node.index]) {
				continue;
			}
			for (int i = 1; i < n + 1; i++) {
				int next_cost = cur_node.cost + map[cur_node.index][i];
				if (map[cur_node.index][i] != 0 && next_cost <= distance[i]) {
					pq.add(new Node(i, next_cost));
					distance[i] = next_cost;
				}
			}
		}
		int ret = 0;
		for (int i = 1; i < n + 1; i++) {
			if (distance[i] <= m) {
				ret += items[i];
			}
		}
		return ret;
	}

	static class Node {
		int index;
		int cost;

		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}
	}
}