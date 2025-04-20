import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int n, m;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	private static int clean(int r, int c, int d) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.offer(new int[] { r, c });

		int cnt = 0;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			if (map[now[0]][now[1]] == 0) {
				map[now[0]][now[1]] = -1;
				cnt++;
			}

			boolean flag = false;

			for (int i = 0; i < 4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];

				if (isInRange(nx, ny) && map[nx][ny] == 0) {
					flag = true;
					break;
				}
			}

			if (flag) { // 청소되지 않은 빈칸이 있는 경우
				d = (d + 3) % 4;

				if (isInRange(now[0] + dx[d], now[1] + dy[d])) {
					if (map[now[0] + dx[d]][now[1] + dy[d]] == 0) { // 청소되지 않은 빈칸인 경우
						queue.offer(new int[] { now[0] + dx[d], now[1] + dy[d] });
					} else {
						queue.offer(new int[] { now[0], now[1] });
					}
				}
			} else { // 청소되지 않은 빈칸이 없는 경우
				int nx = now[0] + dx[(d + 2) % 4];
				int ny = now[1] + dy[(d + 2) % 4];

				if (isInRange(nx, ny) && (map[nx][ny] != 1)) { // 후진할 수 있다면(벽X)
					queue.offer(new int[] { nx, ny });
				} else {
					return cnt;
				}
			}
		}

		return cnt;
	}

	public static boolean isInRange(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < m;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = clean(r, c, d);

		System.out.println(cnt);
	}
}
