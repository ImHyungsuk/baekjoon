import java.io.*;
import java.util.*;

public class Main {
	static int T, N, M;
	static long[] a, b, aSum, bSum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		a = new long[N + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			a[i] = a[i - 1] + Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		b = new long[M + 1];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= M; i++) {
			b[i] = b[i - 1] + Integer.parseInt(st.nextToken());
		}
		int aSize = N * (N + 1) / 2;
		int bSize = M * (M + 1) / 2;
		aSum = new long[aSize];
		bSum = new long[bSize];
		int idx = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = i; j <= N; j++) {
				long av = a[j];
				av -= a[i - 1];
				aSum[idx++] = av;
			}
		}
		idx = 0;
		for (int i = 1; i <= M; i++) {
			for (int j = i; j <= M; j++) {
				long av = b[j];
				av -= b[i - 1];
				bSum[idx++] = av;
			}
		}

		Arrays.sort(aSum);
		Arrays.sort(bSum);

		int left = 0;
		int right = bSize - 1;
		long cnt = 0;
		while (left < aSize && right > -1) {
			long asv = aSum[left], bsv = bSum[right];
			long sum = asv + bsv;
			if (sum == T) {
				int ac = 0, bc = 0;
				while (left < aSize && asv == aSum[left]) {
					left++;
					ac++;
				}
				while (right > -1 && bsv == bSum[right]) {
					right--;
					bc++;
				}
				cnt += (long)bc * ac;
			} else if (sum < T) {
				left++;
			} else {
				right--;
			}
		}
		System.out.println(cnt);
	}
}