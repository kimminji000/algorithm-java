import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int chessTable, knightX, knightY, fianlX, finalY;
	static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[][] visited;

	public static int bfs(int a, int b) {
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { a, b });
		visited[a][b] = 1;
		int nowX = a, nowY = b;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			nowX = now[0];
			nowY = now[1];

			if (nowX == fianlX && nowY == finalY) {
				break;
			}

			for (int i = 0; i < 8; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (nextX >= 0 && nextX < chessTable && nextY >= 0 && nextY < chessTable
						&& visited[nextX][nextY] == 0) {
					queue.add(new int[] { nextX, nextY });
					visited[nextX][nextY] = visited[nowX][nowY] + 1;
				}
			}
		}

		return visited[nowX][nowY] - 1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			chessTable = Integer.parseInt(br.readLine());

			visited = new int[chessTable][chessTable];

			StringTokenizer st = new StringTokenizer(br.readLine());

			knightX = Integer.parseInt(st.nextToken());
			knightY = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			fianlX = Integer.parseInt(st.nextToken());
			finalY = Integer.parseInt(st.nextToken());

			int count = bfs(knightX, knightY);

			sb.append(count).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
