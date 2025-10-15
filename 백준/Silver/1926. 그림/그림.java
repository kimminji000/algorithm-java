import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int n, m;
	static int cnt = 0;
	static int size = 0;

	static void bfs(int x, int y) {
		ArrayDeque<int[]> queue = new ArrayDeque<>();

		queue.offer(new int[] { x, y });
		visited[x][y] = true;

		int check = 1;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = curr[0] + dx[i];
				int nextY = curr[1] + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
					continue;
				}

				if (map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
					queue.offer(new int[] { nextX, nextY });
					visited[nextX][nextY] = true;
					check++;
				}
			}
		}

		cnt++;
		size = Math.max(size, check);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}

		System.out.println(cnt);
		System.out.println(size);
	}
}
