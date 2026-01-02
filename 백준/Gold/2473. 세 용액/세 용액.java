import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		ans = new int[3];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		long min = Long.MAX_VALUE;
		for (int i = 0; i < N - 2; i++) {
			int l = i + 1, r = N - 1;
			while (l < r) {
				long sum = (long)arr[i] + arr[l] + arr[r];
				long tmp = sum > 0 ? sum : -sum;
				if (tmp == 0) {
					Answer(i, l, r);
					System.out.println(arr[i] + " " + arr[l] + " " + arr[r]);
					return;
				} else if (tmp < min) {
					min = tmp;
					Answer(i, l, r);
				}
				if (sum > 0) {
					r--;
				} else
					l++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			sb.append(ans[i]).append(" ");
		}
		System.out.println(sb);
	}

	static void Answer(int s, int mid, int e) {
		ans[0] = arr[s];
		ans[1] = arr[mid];
		ans[2] = arr[e];
	}

}