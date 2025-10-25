import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		arr = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int lengthOfLIS = getLengthOfLIS();
		System.out.println(lengthOfLIS);
	}

	private static int getLengthOfLIS() {
		ArrayList<Integer> lis = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int cur = arr[i];
			if (lis.isEmpty() || lis.get(lis.size()- 1) < cur) {
				lis.add(cur);
			} else {
				int s = 0, e = lis.size() - 1;
				while (s < e) {
					int mid = (s + e) / 2;
					if (lis.get(mid) >= cur) {
						e = mid;
					} else {
						s = mid + 1;
					}
				}
				lis.set(e, cur);
			}
		}
		return lis.size();
	}
}