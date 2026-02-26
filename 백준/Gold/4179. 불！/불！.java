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

	private static int bfs(int jx, int jy, List<int[]> fire) {
		int cnt = 0;

		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { jx, jy });
		for (int i = 0; i < fire.size(); i++) {
			queue.add(new int[] { fire.get(i)[0], fire.get(i)[1] });
		}

		boolean flag = false;

		while (!queue.isEmpty() && !flag) {
			int[] now = queue.poll();

			if (graph[now[0]][now[1]] == 'F') {
				for (int i = 0; i < 4; i++) {
					int nx = now[0] + dx[i];
					int ny = now[1] + dy[i];

					if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
						continue;
					}
					if (graph[nx][ny] != '#' && graph[nx][ny] != 'F') {
						queue.add(new int[] { nx, ny });
						graph[nx][ny] = 'F';
					}
				}
			} else {
				if (graph[now[0]][now[1]] != 'F') {
					for (int i = 0; i < 4; i++) {
						int nx = now[0] + dx[i];
						int ny = now[1] + dy[i];

						if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
							flag = true;
							cnt = visited[now[0]][now[1]];
							break;
						}
						if (graph[nx][ny] == '.' && visited[nx][ny] == 0) {
							queue.add(new int[] { nx, ny });
							visited[nx][ny] = visited[now[0]][now[1]] + 1;
						}
					}
				}
			}
		}

		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		graph = new char[r][c];
		visited = new int[r][c];
		int jx = 0, jy = 0;
		List<int[]> fire = new ArrayList<int[]>();

		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				graph[i][j] = str.charAt(j);

				if (graph[i][j] == 'J') {
					jx = i;
					jy = j;
					visited[i][j] = 1;
				} else if (graph[i][j] == 'F') {
					fire.add(new int[] { i, j });
				}
			}
		}

		int cnt = bfs(jx, jy, fire);

		if (cnt != 0) {
			System.out.println(cnt);
		} else {
			System.out.println("IMPOSSIBLE");
		}
	}
}
