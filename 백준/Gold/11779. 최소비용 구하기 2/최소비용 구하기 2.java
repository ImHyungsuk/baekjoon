import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static ArrayList<Node>[] next;
	static int[] routes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		next = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			next[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			next[s].add(new Node(e, w));
		}
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		System.out.println(dijkstra(s, e));
		ArrayList<Integer> route = new ArrayList<>();
		int idx = e;
		while (idx != 0) {
			route.add(idx);
			idx = routes[idx];
		}
		System.out.println(route.size());
		StringBuilder sb = new StringBuilder();
		for (int i = route.size() - 1; i >= 0; i--) {
			sb.append(route.get(i)).append(" ");
		}
		System.out.println(sb);
	}

	static int dijkstra(int s, int e) {
		routes = new int[n + 1];
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[s] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(s, 0));
		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int curNum = cur.num;
			int curWeight = cur.weight;
			if (dist[curNum] < curWeight)
				continue;
			if (curNum == e)
				return curWeight;
			for (Node nxt : next[curNum]) {
				if (dist[nxt.num] > dist[curNum] + nxt.weight) {
					dist[nxt.num] = dist[curNum] + nxt.weight;
					pq.add(new Node(nxt.num, dist[nxt.num]));
					routes[nxt.num] = curNum;
				}
			}
		}
		return dist[e];
	}
}
class Node implements Comparable<Node>{
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