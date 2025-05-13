import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
	public static int N, K, A, B, cnt = 0, cost = 0;
	// public static int[]A, B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		ArrayList<Integer> arrayList = new ArrayList<>();
		Comparator<Integer> comparator = Comparator.comparingInt(o -> o);

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			if (A >= B) {
				cnt++;
			}else{
				arrayList.add(B - A);
			}
		}
		arrayList.sort(comparator);
		arrayList.sort(Comparator.naturalOrder());
		if (K - cnt > 0) {
			cost = arrayList.get(K - cnt - 1);
		}
		sb.append(cost);
		System.out.println(sb);
	}
}