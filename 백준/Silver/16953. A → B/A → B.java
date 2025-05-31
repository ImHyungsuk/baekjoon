import java.util.*;
import java.io.*;

public class Main {
	static long A, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		System.out.println(dp());
	}

	static long dp() {
		long ret = 987654;
		Queue<Value> q = new ArrayDeque<>();
		q.add(new Value(A, 0));
		while (!q.isEmpty()) {
			Value cur = q.poll();
			if (cur.num == B) {
				ret = Math.min(cur.cnt, ret);
			}
			for (int i = 0; i < 2; i++) {
				long next;
				if (i == 0) {
					next = cur.num * 2;
				} else {
					next = cur.num * 10 + 1;
				}
				if (next > B) {
					continue;
				}
				q.add(new Value(next, cur.cnt + 1));
			}
		}
		if (ret == 987654) {
			return -1;
		}
		return ret + 1;
	}

	static class Value {
		long num;
		long cnt;

		public Value(long num, long cnt) {
			this.num = num;
			this.cnt = cnt;
		}
	}
}