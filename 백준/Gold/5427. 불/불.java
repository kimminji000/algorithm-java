import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int w, h;
	static char[][] graph;
	static int[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static int[][] firebfs(List<int[]> fires) {
		int[][] fireTime = new int[h][w];

		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < fires.size(); i++) {
			fireTime[fires.get(i)[0]][fires.get(i)[1]] = 1;
			queue.add(new int[] { fires.get(i)[0], fires.get(i)[1] });
		}

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];

				if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
					continue;
				}

				if (graph[nx][ny] != '#' && fireTime[nx][ny] == 0) {
					fireTime[nx][ny] = fireTime[now[0]][now[1]] + 1;
					queue.add(new int[] { nx, ny });
				}
			}
		}

		return fireTime;
	}

	private static int bfs(int a, int b, int[][] fireTime) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { a, b });
		visited[a][b] = 1;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];

				if (nx < 0 || ny < 0 || nx >= h || ny >= w) {
					return visited[now[0]][now[1]];
				}

				if (graph[nx][ny] == '.' && visited[nx][ny] == 0
						&& (visited[now[0]][now[1]] + 1 < fireTime[nx][ny] || fireTime[nx][ny] == 0)) {
					visited[nx][ny] = visited[now[0]][now[1]] + 1;
					queue.add(new int[] { nx, ny });
				}
			}
		}

		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			graph = new char[h][w];
			visited = new int[h][w];

			int a = 0, b = 0;
			List<int[]> fires = new ArrayList<int[]>();

			for (int i = 0; i < h; i++) {
				String str = br.readLine();

				for (int j = 0; j < w; j++) {
					graph[i][j] = str.charAt(j);

					if (graph[i][j] == '@') {
						a = i;
						b = j;
					}

					if (graph[i][j] == '*') {
						fires.add(new int[] { i, j });
					}
				}
			}

			int[][] fireTime = firebfs(fires);
			int cnt = bfs(a, b, fireTime);

			if (cnt != 0) {
				System.out.println(cnt);
			} else {
				System.out.println("IMPOSSIBLE");
			}
		}
	}
}
