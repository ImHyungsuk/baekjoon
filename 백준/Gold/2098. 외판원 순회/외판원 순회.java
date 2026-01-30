import java.util.*;
import java.io.*;

public class Main {
	static int N, INF = 987654321, fullBit;
	static int[][] map, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		fullBit = (1 << N) - 1;
		map = new int[N][N];
		dp = new int[N][fullBit];
		for (int i = 0; i < N; i++) {
			Arrays.fill(dp[i], -1);
		}
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(tsp(0, 1));
	}

	static int tsp(int n, int check) {
		if (check == fullBit) {
			if (map[n][0] == 0)
				return INF;
			else
				return map[n][0];
		}
		if (dp[n][check] != -1) {
			return dp[n][check];
		}

		dp[n][check] = INF;

		for (int i = 0; i < N; i++) {
			int nextStatus = check | (1 << i);
			if (map[n][i] == 0 || (check & (1 << i)) != 0)
				continue;
			dp[n][check] = Math.min(dp[n][check], tsp(i, nextStatus) + map[n][i]);
		}
		return dp[n][check];
	}
}