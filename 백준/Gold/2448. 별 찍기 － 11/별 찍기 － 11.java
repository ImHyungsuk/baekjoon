import java.util.*;
import java.io.*;

public class Main{
	static int N;
	static char[][] stars;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		stars = new char[N][2 * N];
		for (int i=0;i<N;i++){
			Arrays.fill(stars[i], ' ');
		}
		divideStars(N - 1, 0, N);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j=0;j<2*N;j++){
				sb.append(stars[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	public static void divideStars(int x, int y, int N) {
		if (N == 3) {
			stars[y][x] = '*';
			stars[y + 1][x - 1] = stars[y + 1][x + 1] = '*';
			for (int i=0;i<3;i++){
				stars[y + 2][x - i] = stars[y + 2][x + i] = '*';
			}
		} else {
			int cut = N / 2;
			divideStars(x, y, cut);
			divideStars(x - cut, y + cut, cut);
			divideStars(x + cut, y + cut, cut);
		}
	}
}