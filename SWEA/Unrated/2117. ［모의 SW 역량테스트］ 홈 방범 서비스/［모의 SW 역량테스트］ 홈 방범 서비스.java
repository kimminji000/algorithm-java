import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			int[][] map = new int[n][n];
			List<int[]> houses = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

					if (map[i][j] == 1) {
						houses.add(new int[] { i, j });
					}
				}
			}

			int maxHouses = 0;
			int maxK = 2 * n;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (int K = 1; K <= maxK; K++) {
						int cost = K * K + (K - 1) * (K - 1);
						int count = 0;

						for (int[] house : houses) {
							int hx = house[0];
							int hy = house[1];
							if (Math.abs(i - hx) + Math.abs(j - hy) < K) {
								count++;
							}
						}

						if (count * m >= cost) {
							maxHouses = Math.max(maxHouses, count);
						}
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(maxHouses).append("\n");
		}

		System.out.println(sb.toString());
	}
}
