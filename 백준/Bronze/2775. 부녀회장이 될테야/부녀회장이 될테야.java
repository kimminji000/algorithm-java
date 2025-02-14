import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());

			int[][] cnt = new int[k + 1][n + 1];

			for (int j = 1; j <= n; j++) {
				cnt[0][j] = j;
			}

			for (int j = 1; j <= k; j++) {
				for (int l = 1; l <= n; l++) {
					for (int m = 1; m <= l; m++) {
						cnt[j][l] += cnt[j - 1][m];
					}
				}
			}

			sb.append(cnt[k][n]).append("\n");
		}

		bw.append(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
