import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int n, m;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static int bfs(int x, int y) {
		Queue<int[]> queue = new ArrayDeque<>();

		queue.offer(new int[] { x, y });
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = curr[0] + dx[i];
				int ny = curr[1] + dy[i];

				if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
					continue;
				}

				if (map[nx][ny] == 1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					map[nx][ny] = map[curr[0]][curr[1]] + 1;
					queue.offer(new int[] { nx, ny });

					if (nx == n - 1 && ny == m - 1) {
						return map[nx][ny];
					}
				}
			}
		}

		return map[n - 1][m - 1];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();

			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		int cnt = bfs(0, 0);

		System.out.println(cnt);
	}
}
