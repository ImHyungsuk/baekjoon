import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] dp, A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		dp = new int[N];
		A = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int[] lis = new int[N];
		lis[0] = A[0];
		int lengthOfLIS = 1;
		for (int i = 1; i < N; i++) {
			if (lis[lengthOfLIS - 1] < A[i]) {
				lis[lengthOfLIS] = A[i];
				lengthOfLIS++;
			} else {
				int lo = 0;
				int hi = lengthOfLIS;
				while (lo < hi) {
					int mid = (lo + hi) / 2;
					if (lis[mid] < A[i]) {
						lo = mid + 1;
					} else {
						hi = mid;
					}
				}
				lis[lo] = A[i];
			}
		}
		System.out.println(lengthOfLIS);
	}
}
