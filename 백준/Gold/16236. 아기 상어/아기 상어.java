import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[][] map;
	private static int n;
	private static int[] dx = { -1, 0, 0, 1 };
	private static int[] dy = { 0, -1, 1, 0 };

	private static class Fish implements Comparable<Fish> {
		int x;
		int y;
		int dist;

		public Fish(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public int compareTo(Fish o) {
			if (this.dist == o.dist) {
				if (this.x == o.x) {
					return Integer.compare(this.y, o.y);
				}

				return Integer.compare(this.x, o.x);
			}

			return Integer.compare(this.dist, o.dist);
		}
	}

	private static int bfs(int x, int y) {
		int size = 2;
		int count = 0;
		int time = 0;

		while (true) {
			int[][] visited = new int[n][n];
			visited[x][y] = 1;

			Queue<int[]> queue = new ArrayDeque<>();
			queue.offer(new int[] { x, y });

			PriorityQueue<Fish> pq = new PriorityQueue<>();

			while (!queue.isEmpty()) {
				int[] curr = queue.poll();

				for (int i = 0; i < 4; i++) {
					int nextX = curr[0] + dx[i];
					int nextY = curr[1] + dy[i];

					if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
						continue;
					}
					if (visited[nextX][nextY] != 0 || map[nextX][nextY] > size) {
						continue;
					}

					visited[nextX][nextY] = visited[curr[0]][curr[1]] + 1;

					if (map[nextX][nextY] != 0 && map[nextX][nextY] < size) {
						pq.offer(new Fish(nextX, nextY, visited[nextX][nextY] - 1));
					}
					queue.offer(new int[] { nextX, nextY });
				}
			}

			if (pq.isEmpty()) {
				break;
			}

			Fish target = pq.poll();
			x = target.x;
			y = target.y;
			time += target.dist;
			map[x][y] = 0;

			count++;
			if (count == size) {
				size++;
				count = 0;
			}
		}

		return time;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		map = new int[n][n];

		int x = 0, y = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					x = i;
					y = j;
					map[x][y] = 0;
				}
			}
		}

		int time = bfs(x, y);

		System.out.println(time);
	}
}
