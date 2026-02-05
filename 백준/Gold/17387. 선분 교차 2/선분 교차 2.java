import java.util.*;
import java.io.*;

public class Main {
	static Point[] points = new Point[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 2; j++) {
				points[i * 2 + j] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
		}
		int s1 = ccw(points[0], points[1], points[2]) * ccw(points[0], points[1], points[3]);
		int s2 = ccw(points[2], points[3], points[0]) * ccw(points[2], points[3], points[1]);
		if (s1 == 0 && s2 == 0) {
			if (Math.min(points[0].x, points[1].x) <= Math.max(points[2].x, points[3].x) &&
				Math.min(points[2].x, points[3].x) <= Math.max(points[0].x, points[1].x) &&
				Math.min(points[0].y, points[1].y) <= Math.max(points[2].y, points[3].y) &&
				Math.min(points[2].y, points[3].y) <= Math.max(points[0].y, points[1].y)) {
				System.out.println(1);
			} else
				System.out.println(0);
		} else if (s1 <= 0 && s2 <= 0) {
			System.out.println(1);
		} else
			System.out.println(0);
	}

	static int ccw(Point p1, Point p2, Point p3) {
		long[] v1 = {p2.x - p1.x, p2.y - p1.y};
		long[] v2 = {p3.x - p1.x, p3.y - p1.y};
		long scalar = v2[1] * v1[0] - v2[0] * v1[1];
		if (scalar > 0)
			return 1;
		else if (scalar < 0)
			return -1;
		else
			return 0;
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}