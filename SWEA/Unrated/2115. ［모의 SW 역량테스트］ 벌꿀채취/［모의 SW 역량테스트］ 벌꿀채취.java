import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int m, c, maxProfit, maxNum;
	static int[][] honey;

	static void getMaxHoney(int i, int j, int cnt, int sum, int profit) {
		if (sum > c) {
			return;
		}

		if (cnt == m) {
			if (maxNum < profit) {
				maxNum = profit;
			}

			return;
		}

		getMaxHoney(i, j + 1, cnt + 1, sum + honey[i][j], profit + honey[i][j] * honey[i][j]);
		getMaxHoney(i, j + 1, cnt + 1, sum, profit);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			honey = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < n; j++) {
					honey[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int maxProfit = 0;
			int profit1 = 0;
			int profit2 = 0;

			for (int i1 = 0; i1 < n; i1++) {
				for (int j1 = 0; j1 <= n - m; j1++) {
					maxNum = 0;
					getMaxHoney(i1, j1, 0, 0, 0);
					profit1 = maxNum;

					maxNum = 0;
					profit2 = 0;

					for (int i2 = i1; i2 < n; i2++) {
						int startJ = 0;

						if (i1 == i2) {
							startJ = j1 + m;
						}

						for (int j2 = startJ; j2 <= n - m; j2++) {
							getMaxHoney(i2, j2, 0, 0, 0);
							profit2 = Math.max(profit2, maxNum);
						}
					}

					maxProfit = Math.max(maxProfit, profit1 + profit2);
				}
			}

			sb.append("#").append(tc).append(" ").append(maxProfit).append("\n");
		}

		System.out.println(sb.toString());
	}
}
