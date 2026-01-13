import java.util.*;
import java.io.*;

public class Main {
	static int P, G;
	static int[] parents, gates;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		G = Integer.parseInt(st.nextToken());
		parents = new int[G + 1];
		for (int i = 0; i <= G; i++) {
			parents[i] = i;
		}
		st = new StringTokenizer(br.readLine());
		P = Integer.parseInt(st.nextToken());
		gates = new int[P];
		for (int i = 0; i < P; i++) {
			gates[i] = Integer.parseInt(br.readLine());
		}
		int ans = 0;
		for (int gate : gates) {
			int p = find(gate);
			if (p == 0) {
				break;
			}
			ans++;
			union(p, p - 1);
		}
		System.out.println(ans);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x > y) {
			parents[x] = y;
		} else if (x < y) {
			parents[y] = x;
		}
	}

	static int find(int g) {
		if (parents[g] == g) {
			return g;
		}
		return parents[g] = find(parents[g]);
	}
}