import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int white;
	static int blue;

	static void check(int[][] paper, int x1, int y1, int x2, int y2) {
		int color = paper[x1][y1];

		for (int i = x1; i < x2; i++) {
			for (int j = y1; j < y2; j++) {
				if (paper[i][j] != color) {
					check(paper, x1, y1, (x1 + x2) / 2, (y1 + y2) / 2);
					check(paper, x1, (y1 + y2) / 2, (x1 + x2) / 2, y2);
					check(paper, (x1 + x2) / 2, y1, x2, (y1 + y2) / 2);
					check(paper, (x1 + x2) / 2, (y1 + y2) / 2, x2, y2);
					return;
				}
			}
		}

		if (color == 0) {
			white++;
		} else if (color == 1) {
			blue++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] paper = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		white = 0;
		blue = 0;

		check(paper, 0, 0, n, n);

		System.out.println(white);
		System.out.println(blue);
	}
}
