import java.util.*;
import java.io.*;

public class Main{
	static int N, M;
	static ArrayList<Integer> num, ret;
	static int[] count;
	static Stack<Integer> stack;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		num = new ArrayList<Integer>();
		ret = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		count = new int[10001];
		for (int i = 0; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			if (count[tmp] == 0) {
				num.add(tmp);
				count[tmp]++;
			}
		}
		num.sort(Comparator.naturalOrder());
		back_track(0, 0);
	}

	static void back_track(int cur_index, int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(ret.get(i) + " ");
			}
			System.out.print("\n");
			return;
		}
		for (int i = cur_index; i < num.size(); i++) {
			ret.add(num.get(i));
			back_track(i, cnt + 1);
			ret.remove(cnt);
		}
	}
}