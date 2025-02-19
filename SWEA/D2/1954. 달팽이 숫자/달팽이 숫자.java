import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());

			int[][] num = new int[n][n];

			int number = 1;

			for (int j = 0; j < (n + 1) / 2; j++) {
				for (int i = j; i < n - j; i++) {
					num[j][i] = number++;
				}
				for (int i = 1 + j; i < n - j; i++) {
					num[i][n - 1 - j] = number++;
				}
				for (int i = 1 + j; i < n - j; i++) {
					num[n - 1 - j][n - 1 - i] = number++;
				}
				for (int i = 1 + j; i < n - 1 - j; i++) {
					num[n - 1 - i][j] = number++;
				}
			}

			sb.append("#").append(tc).append("\n");

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					sb.append(num[i][j]).append(" ");
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
