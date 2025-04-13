import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int knapsack(int n, int k, int[] volume, int[] cost) {
		int[][] dp = new int[n + 1][k + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
				if (volume[i] <= j) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - volume[i]] + cost[i]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[n][k];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			int[] volume = new int[n + 1];
			int[] cost = new int[n + 1];

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());

				volume[i] = Integer.parseInt(st.nextToken());
				cost[i] = Integer.parseInt(st.nextToken());
			}

			int maxValue = knapsack(n, k, volume, cost);

			sb.append("#").append(tc).append(" ").append(maxValue).append("\n");

		}

		System.out.println(sb.toString());
	}
}
