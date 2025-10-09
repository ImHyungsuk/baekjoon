import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static ArrayList<Wire> arr = new ArrayList<>();
	static int[] dp = new int[501];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr.add(new Wire(a, b));
		}
		Collections.sort(arr, (o1, o2) -> {
			if (o1.a == o2.a) {
				return o1.b - o2.b;
			} else
				return o1.a - o2.a;
		});
		int max = 0;
		for (int i = 0; i < arr.size(); i++) {
			max = Math.max(recur(i), max);
		}
		System.out.println(N - max);
	}

	static int recur(int idx) {
		if (dp[idx] == 0) {
			dp[idx] = 1;
			for (int i = idx + 1; i < N; i++) {
				if (arr.get(i).b > arr.get(idx).b) {
					dp[idx] = Math.max(recur(i) + 1, dp[idx]);
				}
			}
		}
		return dp[idx];
	}
}

class Wire {
	int a, b;

	public Wire(int a, int b) {
		this.a = a;
		this.b = b;
	}
}