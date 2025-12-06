import java.util.*;
import java.io.*;

public class Main {
	static int V, E;
	static int[] parents;
	static PriorityQueue<Node> pq = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			pq.add(new Node(to, from, cost));
		}

		parents = new int[V + 1];
		for (int i = 1; i < V + 1; i++) {
			parents[i] = i;
		}

		System.out.println(kruskal());
	}

	static int kruskal() {
		int sum = 0;
		int size = pq.size();
		for (int i = 0; i < size; i++) {
			Node cur = pq.poll();
			int rx = find(cur.to);
			int ry = find(cur.from);
			if (rx != ry) {
				union(cur.to, cur.from);
				sum += cur.cost;
			}
		}
		return sum;
	}

	static int find(int x) {
		if (parents[x] == x) {
			return x;
		}
		return parents[x]=find(parents[x]);

	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x != y) {
			parents[y] = x;
		}
	}
}

class Node implements Comparable<Node> {
	int to, from, cost;

	public Node(int to, int from, int cost) {
		this.to = to;
		this.from = from;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
}