import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[][] cheese;
	private static int[] dx = { -1, 1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };

	private static int bfs(int n, int m, int count) {
		int[][] visited = new int[n][m];

		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { 0, 0 });

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = curr[0] + dx[i];
				int nextY = curr[1] + dy[i];

				if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
					continue;
				}

				if (cheese[nextX][nextY] == 0 && visited[nextX][nextY] == 0) { // 미방문 외부공기
					queue.offer(new int[] { nextX, nextY });
				}
				visited[nextX][nextY]++;
			}
		}

		for (int i = 1; i < n - 1; i++) { // 치즈 삭제
			for (int j = 1; j < m - 1; j++) {
				if (cheese[i][j] == 1 && visited[i][j] >= 2) {
					cheese[i][j] = 0;
					count--;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		cheese = new int[n][m];

		int count = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				cheese[i][j] = Integer.parseInt(st.nextToken());
				if (cheese[i][j] == 1) {
					count++;
				}
			}
		}

		int time = 0;
		while (count > 0) {
			count = bfs(n, m, count);
			time++;
		}

		System.out.println(time);
	}
}
