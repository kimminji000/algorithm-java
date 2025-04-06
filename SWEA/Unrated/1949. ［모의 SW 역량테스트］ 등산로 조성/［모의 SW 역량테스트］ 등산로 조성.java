import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int n, k, maxLen, maxHeight;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void dfs(int x, int y, int length, boolean cutUsed) {
		if (length > maxLen) {
			maxLen = length;
		}

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || nx >= n || ny < 0 || ny >= n || visited[nx][ny]) {
				continue;
			}

			if (map[nx][ny] < map[x][y]) {
				visited[nx][ny] = true;
				dfs(nx, ny, length + 1, cutUsed);
				visited[nx][ny] = false;
			} else if (!cutUsed && map[nx][ny] - k < map[x][y]) {
				int original = map[nx][ny];
				map[nx][ny] = map[x][y] - 1;
				visited[nx][ny] = true;
				dfs(nx, ny, length + 1, true);
				visited[nx][ny] = false;
				map[nx][ny] = original;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			map = new int[n][n];
			visited = new boolean[n][n];
			maxHeight = 0;
			maxLen = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

					if (map[i][j] > maxHeight) {
						maxHeight = map[i][j];
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == maxHeight) {
						visited[i][j] = true;
						dfs(i, j, 1, false);
						visited[i][j] = false;
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(maxLen).append("\n");
		}

		System.out.println(sb.toString());
	}
}
