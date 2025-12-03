import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] list;
	static int[] numOfChild;

	public static void main(String[] args) throws IOException {
		int N, R, Q;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		numOfChild = new int[N + 1];
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
			numOfChild[i] = 1;
		}
		for (int i = 0; i < N - 1; i++) {
			int p, c;
			st = new StringTokenizer(br.readLine(), " ");
			p = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			list[p].add(c);
			list[c].add(p);
		}

		traversal(R, -1);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			sb.append(numOfChild[Integer.parseInt(st.nextToken())]).append("\n");
		}
		System.out.println(sb);
	}

	static void traversal(int cur, int prev) {
		for (int idx : list[cur]) {
			if (idx != prev) {
				traversal(idx, cur);
			}
		}
		if (prev != -1) {
			numOfChild[prev] += numOfChild[cur];
		}
	}
}