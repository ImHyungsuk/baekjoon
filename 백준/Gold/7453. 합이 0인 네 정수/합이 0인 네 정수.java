import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] a, b, c, d;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		a = new int[N + 1];
		b = new int[N + 1];
		c = new int[N + 1];
		d = new int[N + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
		}
		int size = N * N;
		int[] sum1 = new int[size], sum2 = new int[size];
		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum1[idx] = a[i] + b[j];
				sum2[idx] = c[i] + d[j];
				idx++;
			}
		}
		Arrays.sort(sum1);
		Arrays.sort(sum2);
		int left = 0, right = size - 1;
		long cnt = 0;
		while (left < size && right > -1) {
			int lsv = sum1[left], rsv = sum2[right];
			if (lsv + rsv == 0) {
				int lc = 0, rc = 0;
				while (left < size && lsv == sum1[left]) {
					left++;
					lc++;
				}
				while (right > -1 && rsv == sum2[right]) {
					right--;
					rc++;
				}
				cnt += (long)lc * rc;
			} else if (lsv + rsv > 0) {
				right--;
			} else
				left++;
		}
		System.out.println(cnt);
	}
}