import java.util.*;
import java.io.*;
import java.util.logging.XMLFormatter;

public class Main {
	static int X = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int[] N = new int[M];
		int[] S = new int[M];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N[i] = Integer.parseInt(st.nextToken());
			S[i] = Integer.parseInt(st.nextToken());
		}
		Solution(M, N, S);
	}

	static void Solution(int M, int[] N, int[] S) {
		long child = 0;
		long parent = 1;
		long ans = 0;
		for (int i = 0; i < M; i++) {
			child = child * N[i] + S[i] * parent;
			parent *= N[i];
			child %= X;
			parent %= X;
		}
		System.out.println(times(pow(parent, X - 2), child) % X);
	}

	static long times(long a, long b) {
		return a * b % X;
	}

	static long pow(long n, int e) {
		if (e == 1) {
			return n;
		}
		long ret = pow(n, e / 2);
		ret = times(ret, ret);
		if (e % 2 == 1) {
			ret = times(ret, n);
		}
		return ret;
	}
}