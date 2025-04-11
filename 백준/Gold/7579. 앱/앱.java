import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int knapsack(int n, int m, int[] memory, int[] cost) {
		int costSum = 0;
		for (int i = 1; i <= n; i++) {
			costSum += cost[i];
		}

		int[][] dp = new int[n + 1][costSum + 1];
		int minCost = Integer.MAX_VALUE;

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= costSum; j++) {
				if (cost[i] <= j) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost[i]] + memory[i]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}

				if (dp[i][j] >= m && j < minCost) {
					minCost = j;
				}
			}
		}

		return minCost;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int[] memory = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		int[] cost = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}

		int minCost = knapsack(n, m, memory, cost);

		System.out.println(minCost);
	}
}
