import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int r, c;
	static char[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int bfs(Queue<int[]> queue, int[] s) {
		int[][] visited = new int[r][c];
		visited[s[0]][s[1]] = 1;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int nowX = now[0];
			int nowY = now[1];

			if (map[nowX][nowY] == '*') {
				for (int i = 0; i < 4; i++) {
					int nextX = nowX + dx[i];
					int nextY = nowY + dy[i];

					if (!isInRange(nextX, nextY)) {
						continue;
					}

					if (map[nextX][nextY] == '.') {
						map[nextX][nextY] = '*';
						queue.offer(new int[] { nextX, nextY });
					}
				}
			} else if (map[nowX][nowY] == 'S') {
				for (int i = 0; i < 4; i++) {
					int nextX = nowX + dx[i];
					int nextY = nowY + dy[i];

					if (!isInRange(nextX, nextY)) {
						continue;
					}

					if (map[nextX][nextY] == '.' && visited[nextX][nextY] == 0) {
						map[nextX][nextY] = 'S';
						visited[nextX][nextY] = visited[nowX][nowY] + 1;
						queue.offer(new int[] { nextX, nextY });
					}

					if (map[nextX][nextY] == 'D') {
						return visited[nowX][nowY];
					}
				}
			}
		}

		return 0;
	}

	static boolean isInRange(int x, int y) {
		return x >= 0 && x < r && y >= 0 && y < c;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c];
		int[] s = new int[2];
		Queue<int[]> queue = new ArrayDeque<>();

		for (int i = 0; i < r; i++) {
			String str = br.readLine();

			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);

				if (map[i][j] == '*') {
					queue.offer(new int[] { i, j });
				}

				if (map[i][j] == 'S') {
					s[0] = i;
					s[1] = j;
				}
			}
		}

		queue.offer(new int[] { s[0], s[1] });

		int result = bfs(queue, s);

		if (result == 0) {
			System.out.println("KAKTUS");
		} else {
			System.out.println(result);
		}
	}
}
