import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int[] B = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		Solution(A, B);
	}

	static void Solution(int[] A, int[] B) {
		ArrayList<Integer> tmp = new ArrayList<>();
		int a_index = 0, b_index = 0;
		while (true) {
			int max = 0;
			int maxIdxA = 0;
			int maxIdxB = 0;
			for (int i = a_index; i < A.length; i++) {
				for (int j = b_index; j < B.length; j++) {
					if (A[i] == B[j] && max < A[i]) {
						max = A[i];
						maxIdxA = i + 1;
						maxIdxB = j + 1;
					}
				}
			}
			if (max == 0)
				break;
			tmp.add(max);
			a_index = maxIdxA;
			b_index = maxIdxB;
		}
		System.out.println(tmp.size());
		if (tmp.isEmpty()) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (Integer t : tmp) {
			sb.append(t).append(" ");
		}
		System.out.println(sb);
	}
}