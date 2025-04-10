import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int knapsack(int k, int[] weight, int[] value, int n) {
		int[][] dp = new int[n + 1][k + 1];

		for (int i = 1; i <= n; i++) {
			for (int w = 1; w <= k; w++) {
				if (weight[i] <= w) {
					dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weight[i]] + value[i]);
				} else {
					dp[i][w] = dp[i - 1][w];
				}
			}
		}

		return dp[n][k];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] weight = new int[n + 1];
		int[] value = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}

		int maxValue = knapsack(k, weight, value, n);

		System.out.println(maxValue);
	}
}
