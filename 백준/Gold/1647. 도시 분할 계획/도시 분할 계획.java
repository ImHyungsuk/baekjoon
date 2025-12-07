import java.util.*;
import java.io.*;

public class Main {
	static ArrayList<Node>[] list;
	static boolean[] visited;
	static int N, M, max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}
		visited = new boolean[N + 1];
		int a, b, c;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}

		int total = prim(1);
		System.out.println(total - max);
	}

	static int prim(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int total = 0;
		pq.add(new Node(start, 0));
		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (visited[cur.to]) {
				continue;
			}
			visited[cur.to] = true;
			total += cur.cost;
			max = Math.max(max, cur.cost);
			for (Node next : list[cur.to]) {
				if (!visited[next.to]) {
					pq.add(next);
				}
			}
		}
		return total;
	}
}

class Node implements Comparable<Node> {
	int to, cost;

	public Node(int to, int cost) {
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return this.cost - o.cost;
	}
}