import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] star;

	static void draw(int size, int x, int y) {
		if (size == 3) {
			star[x][y] = '*';
			star[x + 1][y - 1] = '*';
			star[x + 1][y + 1] = '*';
			for (int i = -2; i <= 2; i++) {
				star[x + 2][y + i] = '*';
			}
			return;
		}

		draw(size / 2, x, y);
		draw(size / 2, x + size / 2, y - size / 2);
		draw(size / 2, x + size / 2, y + size / 2);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		star = new char[n][2 * n - 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2 * n - 1; j++) {
				star[i][j] = ' ';
			}
		}

		draw(n, 0, n - 1);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2 * n - 1; j++) {
				sb.append(star[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}
