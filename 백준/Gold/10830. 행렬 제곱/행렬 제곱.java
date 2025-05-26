import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static long B;
	static long[][] v;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		v = new long[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				v[i][j] = Long.parseLong(st.nextToken());
			}
		}
		long[][] ret = solve(v, B);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(ret[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static long[][] solve(long[][] v_tmp, long b) {
		if (b == 1) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					v_tmp[i][j] = v_tmp[i][j] % 1000;
				}
			}
			return v_tmp;
		}
		long[][] ret = solve(v_tmp, b / 2);
		ret = multiply_vector(ret, ret);
		if (b % 2 == 1) {
			ret = multiply_vector(ret, v_tmp);
		}
		return ret;
	}

	static long[][] multiply_vector(long[][] v1, long[][] v2) {
		long[][] ret = new long[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				long sum = 0;
				for (int k = 0; k < N; k++) {
					sum += v1[i][k] * v2[k][j];
				}
				ret[i][j] = sum % 1000;
			}
		}
		return ret;
	}
}