import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int r, c;
	static char[][] graph;
	static int[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static int[][] fireBfs(List<int[]> fires) {
		int[][] fireTime = new int[r][c];

		Queue<int[]> queue = new LinkedList<int[]>();
		for (int i = 0; i < fires.size(); i++) {
			fireTime[fires.get(i)[0]][fires.get(i)[1]] = 1;
			queue.add(new int[] { fires.get(i)[0], fires.get(i)[1] });
		}

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];

				if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
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

	private static int bfs(int jx, int jy, int[][] fireTime) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { jx, jy });

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];

				if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
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
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		graph = new char[r][c];
		visited = new int[r][c];
		int jx = 0, jy = 0;
		List<int[]> fires = new ArrayList<int[]>();

		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				graph[i][j] = str.charAt(j);

				if (graph[i][j] == 'J') {
					jx = i;
					jy = j;
					visited[i][j] = 1;
				} else if (graph[i][j] == 'F') {
					fires.add(new int[] { i, j });
				}
			}
		}

		int[][] fireTime = fireBfs(fires);

		int cnt = bfs(jx, jy, fireTime);

		if (cnt != 0) {
			System.out.println(cnt);
		} else {
			System.out.println("IMPOSSIBLE");
		}
	}
}
