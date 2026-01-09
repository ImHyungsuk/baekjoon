import java.io.*;
import java.util.*;

public class Main {
	static long T;
	static int N, M;
	static long[] a, b, a_sum, b_sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		a = new long[N+1];
		a_sum = new long[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			a[i] = a[i - 1] + Long.parseLong(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		b = new long[M + 1];
		b_sum = new long[M + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= M; i++) {
			b[i] = b[i - 1] + Long.parseLong(st.nextToken());
		}
		int aSize = N * (N + 1) / 2;
		int bSize = M * (M + 1) / 2;
		a_sum = new long[aSize];
		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j <= N; j++) {
				a_sum[idx++] = a[j] - a[i];
			}
		}
		b_sum = new long[bSize];
		idx = 0;
		for (int i = 0; i < M; i++) {
			for (int j = i + 1; j <= M; j++) {
				b_sum[idx++] = b[j] - b[i];
			}
		}
		Arrays.sort(a_sum);
		Arrays.sort(b_sum);

		int left = 0, right = bSize - 1;
		long cnt = 0;
		while (left < aSize && right > -1) {
			long asv = a_sum[left], bsv = b_sum[right];
			long sum = asv + bsv;
			if (sum == T) {
				int ac = 0, bc = 0;
				while (left < aSize && asv == a_sum[left]) {
					ac++;
					left++;
				}
				while (right > -1 && bsv == b_sum[right]) {
					bc++;
					right--;
				}
				cnt += (long)ac * bc;
			} else if (sum < T) {
				left++;
			} else
				right--;
		}
		System.out.println(cnt);
	}
}