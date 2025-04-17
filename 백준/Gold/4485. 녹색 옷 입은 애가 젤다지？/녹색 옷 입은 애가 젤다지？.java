import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int[][] map;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int weight;

		public Node(int x, int y, int weight) {
			super();
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	private static int dijkstra(int n) {
		int[][] dist = new int[n][n];
		for (int i = 0; i < dist.length; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}
		dist[0][0] = map[0][0];

		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.offer(new Node(0, 0, dist[0][0]));

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (now.weight > dist[now.x][now.y]) {
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nextX = now.x + dx[i];
				int nextY = now.y + dy[i];

				if (!isInRange(nextX, nextY, map.length)) {
					continue;
				}

				if (dist[nextX][nextY] > now.weight + map[nextX][nextY]) {
					dist[nextX][nextY] = now.weight + map[nextX][nextY];
					pq.offer(new Node(nextX, nextY, dist[nextX][nextY]));
				}
			}
		}

		return dist[n - 1][n - 1];
	}

	private static boolean isInRange(int x, int y, int n) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = 0;
		while (true) {
			int n = Integer.parseInt(br.readLine());

			if (n == 0) {
				break;
			}

			tc++;

			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sb.append("Problem ").append(tc).append(": ").append(dijkstra(n)).append("\n");
		}

		System.out.println(sb.toString());
	}
}
