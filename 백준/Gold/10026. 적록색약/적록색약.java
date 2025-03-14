import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int bfs(int n) {
		Queue<int[]> queue = new ArrayDeque<>();
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					queue.offer(new int[] { i, j });
					visited[i][j] = true;
					cnt++;

					while (!queue.isEmpty()) {
						int[] now = queue.poll();
						int nowX = now[0];
						int nowY = now[1];

						for (int k = 0; k < 4; k++) {
							int nextX = nowX + dx[k];
							int nextY = nowY + dy[k];

							if (isInRange(nextX, nextY, n) && !visited[nextX][nextY]
									&& map[nowX][nowY] == map[nextX][nextY]) {
								queue.offer(new int[] { nextX, nextY });
								visited[nextX][nextY] = true;
							}
						}
					}
				}
			}
		}

		return cnt;
	}

	static void greenToRed(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 'G') {
					map[i][j] = 'R';
				}
			}
		}
	}

	static boolean isInRange(int x, int y, int n) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		map = new char[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();

			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int nomal = bfs(n);

		visited = new boolean[n][n];
		greenToRed(n);

		int abnormal = bfs(n);

		System.out.println(nomal + " " + abnormal);
	}
}
