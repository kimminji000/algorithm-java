import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void bfs(int x, int y, int n, int m) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { x, y });
		visited[x][y] = 1;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int nowX = now[0];
			int nowY = now[1];

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (isInRange(nextX, nextY, n, m) && visited[nextX][nextY] == 0 && map[nextX][nextY] != 0) {
					queue.offer(new int[] { nextX, nextY });
					visited[nextX][nextY] = visited[nowX][nowY] + 1;
				}
			}
		}
	}

	static boolean isInRange(int x, int y, int n, int m) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new int[n][m];

		int x = 0, y = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					x = i;
					y = j;
				}
			}
		}

		bfs(x, y, n, m);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visited[i][j] == 0 && map[i][j] != 0) {
					sb.append(-1).append(" ");
				} else if (visited[i][j] == 0) {
					sb.append(0).append(" ");
				} else {
					sb.append(visited[i][j] - 1).append(" ");
				}
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}
