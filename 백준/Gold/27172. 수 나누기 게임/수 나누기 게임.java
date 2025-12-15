import java.io.*;
import java.util.*;

public class Main {
	static int[] nums = new int[1000001];
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		Arrays.fill(nums, 110000);
		ArrayList<Integer> arr = new ArrayList<>();
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			nums[tmp] = 0;
			arr.add(tmp);
		}
		for (int i : arr) {
			for (int j = 2; j * i < 1000001; j++) {
				if (nums[i * j] <110000) {
					nums[i]++;
					nums[i * j]--;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i : arr) {
			sb.append(nums[i]).append(" ");
		}
		System.out.println(sb);
	}
}