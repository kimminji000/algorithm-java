import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] num = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[n + 1][2];
		dp[0][0] = 0;
		dp[0][1] = 0;

		for (int i = 1; i <= n; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);

			int pointer = i - 1;
			int max = 0;
			while (pointer > 0) {
				if (num[i] > num[pointer] && dp[max][1] < dp[pointer][1]) {
					max = pointer;
				}
				pointer--;
			}

			dp[i][1] = dp[max][1] + 1;
		}

		System.out.println(Math.max(dp[n][0], dp[n][1]));
	}
}
