import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };
	static int[][] graph;
	static boolean[][] visited;

	static int bfs(int num) {
		visited = new boolean[n][n];

		Queue<int[]> queue = new ArrayDeque<>();

		int cnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (graph[i][j] > num && !visited[i][j]) {
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

							if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && graph[nextX][nextY] > num
									&& !visited[nextX][nextY]) {
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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		graph = new int[n][n];
//		int[] check = new int[101];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				graph[i][j] = num;
//				check[num]++;
			}
		}

		int maxCnt = 0;

		for (int i = 0; i <= 100; i++) {
			maxCnt = Math.max(bfs(i), maxCnt);
//			if (check[i] != 0) {
//				maxCnt = Math.max(bfs(i), maxCnt);
//			}
		}

		System.out.println(maxCnt);

		br.close();
	}

}
