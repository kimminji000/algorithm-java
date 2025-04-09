import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Node {
		int x;
		int y;
		int dist;
		int broken;

		public Node(int x, int y, int dist, int broken) {
			super();
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.broken = broken;
		}
	}

	static int bfs(int[][] map, int[][][] visited) {
		Queue<Node> queue = new ArrayDeque<>();

		queue.offer(new Node(0, 0, 1, 0));
		visited[0][0][0] = 1;

		while (!queue.isEmpty()) {
			Node now = queue.poll();

			if (now.x == n - 1 && now.y == m - 1) {
				return now.dist;
			}

			for (int i = 0; i < 4; i++) {
				int x = now.x + dx[i];
				int y = now.y + dy[i];

				if (!isInRange(x, y, map.length, map[0].length)) {
					continue;
				}

				if (map[x][y] == 0 && visited[x][y][now.broken] == 0) {
					visited[x][y][now.broken] = 1;
					queue.offer(new Node(x, y, now.dist + 1, now.broken));
				}

				if (map[x][y] == 1 && now.broken == 0 && visited[x][y][now.broken] == 0) {
					visited[x][y][1] = 1;
					queue.offer(new Node(x, y, now.dist + 1, 1));
				}
			}
		}

		return -1;
	}

	static boolean isInRange(int x, int y, int r, int c) {
		return x >= 0 && x < r && y >= 0 && y < c;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		int[][][] visited = new int[n][m][2];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(str.substring(j, j + 1));
			}
		}

		int result = bfs(map, visited);

		System.out.println(result);
	}
}
