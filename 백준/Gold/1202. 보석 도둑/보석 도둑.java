import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static long ans = 0;
	static Jewerly[] jewerlies;
	static int[] bags;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		jewerlies = new Jewerly[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			jewerlies[i] = new Jewerly(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(jewerlies);
		bags = new int[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			bags[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(bags);
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int i = 0, j = 0; i < K; i++) {
			while (j < N && jewerlies[j].mass <= bags[i]) {
				pq.add(jewerlies[j++].value);
			}
			if (!pq.isEmpty()) {
				ans += pq.poll();
			}
		}
		System.out.println(ans);
	}
}

class Jewerly implements Comparable<Jewerly> {
	int mass, value;

	public Jewerly(int mass, int value) {
		this.mass = mass;
		this.value = value;
	}

	@Override
	public int compareTo(Jewerly o) {
		if (this.mass == o.mass) {
			return o.value - this.value;
		}
		return this.mass - o.mass;
	}
}