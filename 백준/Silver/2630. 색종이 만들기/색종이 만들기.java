import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int[] count = new int[2];

	private static void check(int n, int x, int y) {
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (arr[i][j] != arr[x][y]) {
					int size = n / 2;
					
					for (int dx = 0; dx < 2; dx++) {
						for (int dy = 0; dy < 2; dy++) {
							check(size, x + size * dx, y + size * dy);
						}
					}
					
					return;
				}
			}
		}

		count[arr[x][y]]++;
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

		for (int i = 0; i < 2; i++) {
			System.out.println(count[i]);
		}
	}
}
