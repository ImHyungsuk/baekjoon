import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static int N, cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> plus = new ArrayList<>(), minus = new ArrayList<>();

		N = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int n;
		for (int i = 0; i < N; i++) {
			n = Integer.parseInt(st.nextToken());
			if (n > 0) {
				plus.add(n);
			} else {
				minus.add(n);
			}
		};
		plus.sort(Comparator.naturalOrder());
		minus.sort(Comparator.naturalOrder());
		
		for (int i = 0; i < N + 1; i++) {
			int liarCount = 0;
			liarCount += BinarySearch(plus, i);
			liarCount += BinarySearch(minus, i * (-1));
			// System.out.println("liar: "+liarCount);
			if (liarCount == i) {
				cnt++;
				sb.append(i).append(" ");
			}
		}
		System.out.println(cnt);
		System.out.println(sb);
	}

	public static int BinarySearch(ArrayList<Integer> arr, int c) {
		int start = 0;
		int end = arr.size();
		while (start < end) {
			int mid = (start + end) / 2;
			if (c < arr.get(mid)) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return arr.size() - start;
	}
}
