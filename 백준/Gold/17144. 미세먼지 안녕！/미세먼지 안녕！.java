import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void spreadDust(int[][] map) {
		int r = map.length;
		int c = map[0].length;

		List<int[]> dusts = new ArrayList<>();

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] > 0) {
					dusts.add(new int[] { i, j, map[i][j] });
				}
			}
		}

		for (int i = 0; i < dusts.size(); i++) {
			int[] dust = dusts.get(i);

			for (int j = 0; j < 4; j++) {
				int x = dust[0] + dx[j];
				int y = dust[1] + dy[j];

				if (isInRange(x, y, r, c) && map[x][y] != -1) {
					map[x][y] += dust[2] / 5;
					map[dust[0]][dust[1]] -= dust[2] / 5;
				}
			}
		}

	}

	static void purifyAir(int[][] map, int[] airPurifier) {
		int r = map.length;
		int c = map[0].length;

		for (int i = airPurifier[0] - 1; i > 0; i--) {
			map[i][0] = map[i - 1][0];
		}

		for (int i = 0; i < c - 1; i++) {
			map[0][i] = map[0][i + 1];
		}

		for (int i = 0; i < airPurifier[0]; i++) {
			map[i][c - 1] = map[i + 1][c - 1];
		}

		for (int i = c - 1; i > 1; i--) {
			map[airPurifier[0]][i] = map[airPurifier[0]][i - 1];
		}

		map[airPurifier[0]][1] = 0;

		for (int i = airPurifier[1] + 1; i < r - 1; i++) {
			map[i][0] = map[i + 1][0];
		}

		for (int i = 0; i < c - 1; i++) {
			map[r - 1][i] = map[r - 1][i + 1];
		}

		for (int i = r - 1; i > airPurifier[1]; i--) {
			map[i][c - 1] = map[i - 1][c - 1];
		}

		for (int i = c - 1; i > 1; i--) {
			map[airPurifier[1]][i] = map[airPurifier[1]][i - 1];
		}

		map[airPurifier[1]][1] = 0;
	}

	static boolean isInRange(int x, int y, int r, int c) {
		return x >= 0 && x < r && y >= 0 && y < c;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		int[][] map = new int[r][c];
		int[] airPurifier = new int[2];

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == -1) {
					if (airPurifier[0] == 0) {
						airPurifier[0] = i;
					} else {
						airPurifier[1] = i;
					}
				}
			}
		}

		for (int i = 0; i < t; i++) {
			spreadDust(map);
			purifyAir(map, airPurifier);
		}

		int dustSum = 0;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				dustSum += map[i][j];
			}
		}

		System.out.println(dustSum + 2);
	}
}
