import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, maxSum;
	static int[][] map;

	private static void tetromino1(int x, int y) {
		int[][] dx = { { 0, 0, 0, 0 }, { 0, 1, 2, 3 } };
		int[][] dy = { { 0, 1, 2, 3 }, { 0, 0, 0, 0 } };

		for (int i = 0; i < 2; i++) {
			boolean flag = true;
			int sum = 0;

			for (int j = 0; j < 4; j++) {
				if (isInRange(x + dx[i][j], y + dy[i][j])) {
					sum += map[x + dx[i][j]][y + dy[i][j]];

				} else {
					flag = false;
					break;
				}
			}

			if (flag) {
				maxSum = Math.max(maxSum, sum);
			}
		}
	}

	private static void tetromino2(int x, int y) {
		int[] dx = { 0, 0, 1, 1 };
		int[] dy = { 0, 1, 0, 1 };

		boolean flag = true;
		int sum = 0;

		for (int i = 0; i < 4; i++) {
			if (isInRange(x + dx[i], y + dy[i])) {
				sum += map[x + dx[i]][y + dy[i]];

			} else {
				flag = false;
				break;
			}
		}

		if (flag) {
			maxSum = Math.max(maxSum, sum);
		}
	}

	private static void tetromino3(int x, int y) {
		int[][] dx = { { 0, 1, 2, 2, }, { 0, 0, 0, 1 }, { 0, 0, 1, 2 }, { 0, 1, 1, 1 }, { 0, 1, 2, 2 }, { 0, 0, 0, 1 },
				{ 0, 0, 1, 2 }, { 0, 1, 1, 1 } };
		int[][] dy = { { 0, 0, 0, 1 }, { 0, 1, 2, 0 }, { 0, 1, 1, 1 }, { 2, 0, 1, 2 }, { 1, 1, 0, 1 }, { 0, 1, 2, 2 },
				{ 0, 1, 0, 0 }, { 0, 0, 1, 2 } };

		for (int i = 0; i < 8; i++) {
			boolean flag = true;
			int sum = 0;

			for (int j = 0; j < 4; j++) {
				if (isInRange(x + dx[i][j], y + dy[i][j])) {
					sum += map[x + dx[i][j]][y + dy[i][j]];

				} else {
					flag = false;
					break;
				}
			}

			if (flag) {
				maxSum = Math.max(maxSum, sum);
			}
		}
	}

	private static void tetromino4(int x, int y) {
		int[][] dx = { { 0, 1, 1, 2 }, { 0, 0, 1, 1 }, { 0, 1, 1, 2 }, { 0, 0, 1, 1 } };
		int[][] dy = { { 0, 0, 1, 1 }, { 0, 1, -1, 0 }, { 0, -1, 0, -1 }, { 0, 1, 1, 2 } };

		for (int i = 0; i < 4; i++) {
			boolean flag = true;
			int sum = 0;

			for (int j = 0; j < 4; j++) {
				if (isInRange(x + dx[i][j], y + dy[i][j])) {
					sum += map[x + dx[i][j]][y + dy[i][j]];

				} else {
					flag = false;
					break;
				}
			}

			if (flag) {
				maxSum = Math.max(maxSum, sum);
			}
		}
	}

	private static void tetromino5(int x, int y) {
		int[][] dx = { { 0, 0, 0, 1 }, { 0, 1, 1, 2 }, { 0, 1, 1, 1 }, { 0, 1, 1, 2 } };
		int[][] dy = { { 0, 1, 2, 1 }, { 0, -1, 0, 0 }, { 0, -1, 0, 1 }, { 0, 0, 1, 0 } };

		for (int i = 0; i < 4; i++) {
			boolean flag = true;
			int sum = 0;

			for (int j = 0; j < 4; j++) {
				if (isInRange(x + dx[i][j], y + dy[i][j])) {
					sum += map[x + dx[i][j]][y + dy[i][j]];

				} else {
					flag = false;
					break;
				}
			}

			if (flag) {
				maxSum = Math.max(maxSum, sum);
			}
		}
	}

	private static boolean isInRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tetromino1(i, j);
				tetromino2(i, j);
				tetromino3(i, j);
				tetromino4(i, j);
				tetromino5(i, j);
			}
		}

		System.out.println(maxSum);
	}
}
