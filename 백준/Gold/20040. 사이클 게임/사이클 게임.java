import java.io.*;
import java.util.*;

public class Main {
	static int[] parents;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (find(x) == find(y)) {
				System.out.println(i + 1);
				return;
			} else {
				union(x, y);
			}
		}
		System.out.println(0);
	}

	static int find(int x) {
		if (parents[x] == x) {
			return x;
		} else {
			return parents[x] = find(parents[x]);
		}
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x < y)
			parents[y] = x;
		else
			parents[x] = y;
	}
}