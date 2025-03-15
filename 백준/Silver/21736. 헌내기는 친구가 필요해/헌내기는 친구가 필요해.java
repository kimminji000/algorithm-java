import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[][] map;
	static boolean[][] visited;

	static int bfs(int x, int y, int n, int m) {
		int cnt = 0;

		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { x, y });
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int nowX = now[0];
			int nowY = now[1];

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (isInRange(nextX, nextY, n, m) && map[nextX][nextY] != 'X' && !visited[nextX][nextY]) {
					queue.offer(new int[] { nextX, nextY });
					visited[nextX][nextY] = true;

					if (map[nextX][nextY] == 'P') {
						cnt++;
					}
				}
			}
		}

		return cnt;
	}

	static boolean isInRange(int x, int y, int n, int m) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		visited = new boolean[n][m];

		int x = 0, y = 0;

		for (int i = 0; i < n; i++) {
			String str = br.readLine();

			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'I') {
					x = i;
					y = j;
				}
			}
		}

		int cnt = bfs(x, y, n, m);

		if (cnt == 0) {
			System.out.println("TT");
		} else {
			System.out.println(cnt);
		}
	}
}
