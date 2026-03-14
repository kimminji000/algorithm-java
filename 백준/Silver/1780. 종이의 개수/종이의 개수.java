import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int[] count = new int[3];

	private static void check(int n, int x, int y) {
		boolean flag = true;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[x + i][y + j] != arr[x][y]) {
					flag = false;
					check(n / 3, x, y);
					check(n / 3, x, y + n / 3);
					check(n / 3, x, y + n / 3 * 2);

					check(n / 3, x + n / 3, y);
					check(n / 3, x + n / 3, y + n / 3);
					check(n / 3, x + n / 3, y + n / 3 * 2);

					check(n / 3, x + n / 3 * 2, y);
					check(n / 3, x + n / 3 * 2, y + n / 3);
					check(n / 3, x + n / 3 * 2, y + n / 3 * 2);
					break;
				}
			}

			if (!flag) {
				break;
			}
		}

		if (flag) {
			count[arr[x][y] + 1]++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		check(n, 0, 0);

		for (int i = 0; i < 3; i++) {
			System.out.println(count[i]);
		}
	}
}
