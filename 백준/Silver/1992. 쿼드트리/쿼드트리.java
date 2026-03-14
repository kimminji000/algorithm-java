import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] arr;
	static StringBuilder sb = new StringBuilder();

	private static void quadTree(int n, int x, int y) {
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (arr[i][j] != arr[x][y]) {
					int size = n / 2;

					sb.append("(");
					for (int dx = 0; dx < 2; dx++) {
						for (int dy = 0; dy < 2; dy++) {
							quadTree(size, x + size * dx, y + size * dy);
						}
					}
					sb.append(")");

					return;
				}
			}
		}
		sb.append(arr[x][y]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		arr = new char[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		quadTree(n, 0, 0);

		System.out.println(sb.toString());
	}
}
