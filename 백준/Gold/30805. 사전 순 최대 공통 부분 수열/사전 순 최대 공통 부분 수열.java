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
		recursion(A, B, 0, 0, tmp);
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

	static void recursion(int[] A, int[] B, int a_index, int b_index, ArrayList<Integer> tmp) {
		int max = 0;
		int maxIdxA = 0;
		int maxIdxB = 0;
		for (int i = a_index; i < A.length; i++) {
			for (int j = b_index; j < B.length; j++) {
				if (A[i] == B[j]) {
					if (max < A[i]) {
						// System.out.println(A[i] + " " + i + " " + j);
						max = A[i];
						maxIdxA = i;
						maxIdxB = j;
					}
				}
			}
		}
		if (max == 0)
			return;
		tmp.add(max);
		recursion(A, B, maxIdxA + 1, maxIdxB + 1, tmp);
	}
}