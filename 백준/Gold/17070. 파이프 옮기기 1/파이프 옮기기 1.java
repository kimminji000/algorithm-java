import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[][] house = new int[n + 1][n + 1];
		int[][][] dp = new int[n + 1][n + 1][3];
		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= n; j++) {
				house[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[1][2][0] = 1;

		for (int i = 1; i <= n; i++) {
			for (int j = 3; j <= n; j++) {
				if (house[i][j] == 0) {
					dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][1];
					dp[i][j][2] = dp[i - 1][j][1] + dp[i - 1][j][2];
				}
				if (house[i][j] == 0 && house[i - 1][j] == 0 && house[i][j - 1] == 0) {
					dp[i][j][1] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
				}
			}
		}

		sb.append(Integer.toString(dp[n][n][0] + dp[n][n][1] + dp[n][n][2]));

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
