import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static void rotation(int n, int m, int[][] arr) {
		for (int i = 0; i < Math.min(n, m) / 2; i++) {
			int temp = arr[i][i];

			for (int j = i; j < m - i - 1; j++) {
				arr[i][j] = arr[i][j + 1];
			}

			for (int j = i; j < n - i - 1; j++) {
				arr[j][m - 1 - i] = arr[j + 1][m - 1 - i];
			}

			for (int j = m - 1 - i; j >= 1 + i; j--) {
				arr[n - 1 - i][j] = arr[n - 1 - i][j - 1];
			}

			for (int j = n - 1 - i; j >= 2 + i; j--) {
				arr[j][i] = arr[j - 1][i];
			}

			arr[i + 1][i] = temp;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < r; i++) {
			rotation(n, m, arr);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}
