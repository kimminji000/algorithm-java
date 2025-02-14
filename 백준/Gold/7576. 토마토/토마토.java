import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] graph;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void bfs(int m, int n) {
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (graph[i][j] == 1) {
					queue.add(new int[] { i, j });
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int nowX = now[0];
			int nowY = now[1];

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && graph[nextX][nextY] == 0) {
					queue.add(new int[] { nextX, nextY });
					graph[nextX][nextY] = graph[nowX][nowY] + 1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		graph = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs(m, n);

		int days = 0;
		boolean flag = false;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				days = Math.max(days, graph[i][j]);

				if (graph[i][j] == 0) {
					flag = true;
				}
			}
		}

		if (flag) {
			sb.append(-1);
		} else {
			sb.append(days - 1);
		}
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
