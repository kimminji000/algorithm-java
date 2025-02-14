import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void rotation(int n, int[][] x) {
		int[] temp = new int[n + 1];

		for (int j = 1; j <= n; j++) { // 주 대각선 저장
			temp[j] = x[j][j];
		}

		for (int j = 1; j <= n; j++) { // 가운데 행을 주 대각선으로 옮긴다
			x[j][j] = x[(n + 1) / 2][j];
		}

		for (int j = 1; j <= n; j++) { // 부 대각선을 가운데 행으로 옮긴다(특수)
			x[(n + 1) / 2][n - j + 1] = x[j][n - j + 1];
		}

		for (int j = 1; j <= n; j++) { // 가운데 열을 부 대각선으로 옮긴다
			x[j][n - j + 1] = x[j][(n + 1) / 2];
		}

		for (int j = 1; j <= n; j++) { // 주 대각선을 가운데 열로 옮긴다
			x[j][(n + 1) / 2] = temp[j];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			int[][] x = new int[n + 1][n + 1];

			for (int j = 1; j <= n; j++) {
				st = new StringTokenizer(br.readLine());

				for (int k = 1; k <= n; k++) {
					x[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			if (d == 45 || d == -315) {
				rotation(n, x);
			} else if (d == 90 || d == -270) {
				for (int a = 0; a < 2; a++) {
					rotation(n, x);
				}
			} else if (d == 135 || d == -225) {
				for (int a = 0; a < 3; a++) {
					rotation(n, x);
				}
			} else if (d == 180 || d == -180) {
				for (int a = 0; a < 4; a++) {
					rotation(n, x);
				}
			} else if (d == 225 || d == -135) {
				for (int a = 0; a < 5; a++) {
					rotation(n, x);
				}
			} else if (d == 270 || d == -90) {
				for (int a = 0; a < 6; a++) {
					rotation(n, x);
				}
			} else if (d == 315 || d == -45) {
				for (int a = 0; a < 7; a++) {
					rotation(n, x);
				}
			}

			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					sb.append(Integer.toString(x[j][k])).append(" ");
				}
				sb.append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
