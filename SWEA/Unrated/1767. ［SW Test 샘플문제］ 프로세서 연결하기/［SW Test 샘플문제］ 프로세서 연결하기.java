import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int minLength, maxCore, n;
	static int[][] grid;
	static List<int[]> cores;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void connect(int idx, int coreCnt, int length) {
		if (idx == cores.size()) {
			if (coreCnt > maxCore) {
				maxCore = coreCnt;
				minLength = length;
			} else if (coreCnt == maxCore) {
				minLength = Math.min(minLength, length);
			}
			return;
		}

		int[] core = cores.get(idx);
		int x = core[0];
		int y = core[1];

		for (int dir = 0; dir < 4; dir++) {
			int len = canConnect(x, y, dir);

			if (len > 0) {
				setWire(x, y, dir, 1);
				connect(idx + 1, coreCnt + 1, length + len);
				setWire(x, y, dir, 0);
			}
		}

		connect(idx + 1, coreCnt, length);
	}

	static int canConnect(int x, int y, int dir) {
		int len = 0;

		while (true) {
			x += dx[dir];
			y += dy[dir];

			if (x < 0 || x > n - 1 || y < 0 || y > n - 1) {
				break;
			}

			if (grid[x][y] != 0) {
				return 0;
			}

			len++;
		}

		return len;
	}

	static void setWire(int x, int y, int dir, int value) {
		while (true) {
			x += dx[dir];
			y += dy[dir];

			if (x < 0 || x > n - 1 || y < 0 || y > n - 1) {
				break;
			}

			grid[x][y] = value;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());

			grid = new int[n][n];
			cores = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int j = 0; j < n; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());

					if (grid[i][j] == 1 && i != 0 && i != n - 1 && j != 0 && j != n - 1) {
						cores.add(new int[] { i, j });
					}
				}
			}

			minLength = Integer.MAX_VALUE;
			maxCore = 0;

			connect(0, 0, 0);

			sb.append("#").append(tc).append(" ").append(minLength).append("\n");
		}

		System.out.println(sb.toString());
	}
}
