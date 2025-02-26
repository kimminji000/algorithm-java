import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][][] box;
	static int[] dx = new int[] { -1, 1, 0, 0, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1, 0, 0 };
	static int[] dz = new int[] { 0, 0, 0, 0, -1, 1 };

	static void bfs(int m, int n, int h) {
		Queue<int[]> queue = new ArrayDeque<>();

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (box[i][j][k] == 1) {
						queue.add(new int[] { i, j, k });
					}
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int nowH = now[0];
			int nowN = now[1];
			int nowM = now[2];

			for (int i = 0; i < 6; i++) {
				int nextH = nowH + dz[i];
				int nextN = nowN + dy[i];
				int nextM = nowM + dx[i];

				if (nextH >= 0 && nextH < h && nextN >= 0 && nextN < n && nextM >= 0 && nextM < m
						&& box[nextH][nextN][nextM] == 0) {
					box[nextH][nextN][nextM] = box[nowH][nowN][nowM] + 1;
					queue.offer(new int[] { nextH, nextN, nextM });
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		box = new int[h][n][m];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());

				for (int k = 0; k < m; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		bfs(m, n, h);

		boolean flag = false;
		int max = 0;

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (box[i][j][k] == 0) {
						flag = true;
						break;
					}

					max = Math.max(max, box[i][j][k]);
				}

				if (flag) {
					break;
				}
			}

			if (flag) {
				break;
			}
		}

		if (flag) {
			System.out.println(-1);
		} else {
			System.out.println(max - 1);
		}

		br.close();
	}
}
