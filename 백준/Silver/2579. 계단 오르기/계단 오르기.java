import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] stair = new int[n + 3];

		for (int i = 1; i <= n; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}

		int[][] dp = new int[n + 3][2];

		dp[1][0] = 0;
		dp[1][1] = stair[1];
		dp[2][0] = dp[1][1];
		dp[2][1] = dp[1][1] + stair[2];
		dp[3][0] = dp[2][1];
		dp[3][1] = Math.max(stair[1], stair[2]) + stair[3];

		for (int i = 4; i <= n; i++) {
			dp[i][0] = dp[i - 1][1];
			dp[i][1] = Math.max(dp[i - 3][1] + stair[i - 1], dp[i - 2][1]) + stair[i];
		}

		System.out.println(dp[n][1]);

		br.close();
	}
}
