import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static Num[] nums;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		nums = new Num[N + 1];
		dp = new int[N + 1][N + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			nums[i] = new Num(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		for (int gap = 1; gap < N; gap++) {
			for (int start = 1; start + gap < N + 1; start++) {
				int end = start + gap;
				if (dp[start][end] == 0)
					dp[start][end] = Integer.MAX_VALUE;
				for (int mid = start; mid < end; mid++) {
					dp[start][end] = Math.min(dp[start][end],
						dp[start][mid] + dp[mid + 1][end] + nums[start].r * nums[mid].c * nums[end].c);
				}
			}
		}
		System.out.println(dp[1][N]);
	}
}

class Num {
	int r, c;

	public Num(int r, int c) {
		this.r = r;
		this.c = c;
	}
}