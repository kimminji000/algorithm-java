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
	static int[][] graph;
	static boolean[][] visited;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			graph = new int[n][m];
			visited = new boolean[n][m];

			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				graph[y][x] = 1;
			}

			int cnt = 0;
			for (int a = 0; a < n; a++) {
				for (int b = 0; b < m; b++) {
					if (graph[a][b] == 1 && visited[a][b] == false) {
						bfs(a, b);
						cnt++;
					}
				}
			}
			
			sb.append(cnt).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

	public static void bfs(int a, int b) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { a, b });
		visited[a][b] = true;

		while (!queue.isEmpty()) {
			int now[] = queue.poll();

			for (int i = 0; i < 4; i++) {
				int x = now[0] + dx[i];
				int y = now[1] + dy[i];

				if (x >= 0 && y >= 0 && x < n && y < m) {
					if (graph[x][y] == 1 && visited[x][y] == false) {
						visited[x][y] = true;
						queue.add(new int[] { x, y });
					}
				}
			}
		}
	}
}
