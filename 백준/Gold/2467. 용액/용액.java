import java.util.*;
import java.io.*;

public class Main {
	static int min = 2000000001;
	static int s, e;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Solution(numbers, N);
	}

	static void Solution(int[] numbers, int n) {
		s = 0;
		e = n - 1;
		for (int i = 0; i < n - 1; i++) {
			BinarySearch(i + 1, n - 1, numbers, i);
		}
		System.out.println(numbers[s] + " " + numbers[e]);
	}

	static void BinarySearch(int start, int end, int[] numbers, int s_idx) {
		if (start > end) {
			return;
		}
		int mid = (start + end) / 2;
		int sum = numbers[s_idx] + numbers[mid];
		if (isMin(sum, min)) {
			// System.out.println(sum + " " + min + " " + s_idx + " " + mid);
			s = s_idx;
			e = mid;
			min = sum;
		}
		if (numbers[s_idx] > numbers[mid] * -1) {
			BinarySearch(start, mid - 1, numbers, s_idx);
		} else {
			BinarySearch(mid + 1, end, numbers, s_idx);
		}

	}

	static boolean isMin(int sum, int min) {
		if (sum == 0) {
			return true;
		}
		if (min == 0) {
			return false;
		}
		if (sum > 0) {
			if (min < 0)
				return sum < min * -1;
			else
				return sum < min;
		} else {
			if (min < 0)
				return sum > min;
			else
				return sum > min * -1;
		}
	}
}