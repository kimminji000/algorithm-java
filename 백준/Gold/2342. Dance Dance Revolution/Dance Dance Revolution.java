import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = st.countTokens();

		int[] nums = new int[n];

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int[][][] dp = new int[n][5][5];

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {
					dp[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}

		dp[0][nums[0]][0] = 2;

		for (int i = 1; i < n - 1; i++) {
			for (int j = 0; j < 5; j++) {
				for (int k = 0; k < 5; k++) {///
					if (dp[i - 1][j][k] != Integer.MAX_VALUE) {
						// 왼발을 움직임
						if (j == nums[i]) { // 같은 지점
							dp[i][nums[i]][k] = Math.min(dp[i][nums[i]][k], dp[i - 1][j][k] + 1);
						} else if (Math.abs(j - nums[i]) == 1 || Math.abs(j - nums[i]) == 3) { // 양옆
							dp[i][nums[i]][k] = Math.min(dp[i][nums[i]][k], dp[i - 1][j][k] + 3);
						} else { // 반대
							dp[i][nums[i]][k] = Math.min(dp[i][nums[i]][k], dp[i - 1][j][k] + 4);
						}

						// 오른발을 움직임
						if (k == 0) { // 오른발이 시작 지점
							dp[i][j][nums[i]] = Math.min(dp[i][j][nums[i]], dp[i - 1][j][k] + 2);
						} else if (k == nums[i]) { // 같은 지점
							dp[i][j][nums[i]] = Math.min(dp[i][j][nums[i]], dp[i - 1][j][k] + 1);
						} else if (Math.abs(k - nums[i]) == 1 || Math.abs(k - nums[i]) == 3) { // 양옆
							dp[i][j][nums[i]] = Math.min(dp[i][j][nums[i]], dp[i - 1][j][k] + 3);
						} else { // 반대
							dp[i][j][nums[i]] = Math.min(dp[i][j][nums[i]], dp[i - 1][j][k] + 4);
						}
					}
				}
			}
		}

		int minPower = Integer.MAX_VALUE;

		for (int j = 0; j < 5; j++) {
			for (int k = 0; k < 5; k++) {
				if (dp[n - 2][j][k] != Integer.MAX_VALUE) {
					minPower = Math.min(minPower, dp[n - 2][j][k]);
				}
			}
		}

		System.out.println(minPower);

		br.close();
	}
}
