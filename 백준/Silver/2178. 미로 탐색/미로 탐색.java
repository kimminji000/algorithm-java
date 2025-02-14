import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int[][] graph;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visited = new boolean[n][m];
		graph = new int[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				graph[i][j] = str.charAt(j) - '0';
			}
		}

		bfs(0, 0);

		bw.write(Integer.toString(graph[n - 1][m - 1]));
		bw.flush();
		br.close();
		bw.close();
	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int now[] = queue.poll();

			for (int i = 0; i < 4; i++) {
				int a = now[0] + dx[i];
				int b = now[1] + dy[i];

				if (a >= 0 && b >= 0 && a < n && b < m) {
					if (graph[a][b] == 1 && visited[a][b] == false) {
						visited[a][b] = true;
						graph[a][b] = graph[now[0]][now[1]] + 1;
						queue.add(new int[] { a, b });
					}
				}
			}
		}
	}
}
