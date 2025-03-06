import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] graph;
	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };
	static int cnt;
	static int n;

	static void search(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && graph[nextX][nextY] == graph[x][y] + 1) {
				cnt++;
				search(nextX, nextY);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());

			graph = new int[n][n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int j = 0; j < n; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int maxRoom = 0, roomNum = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					cnt = 1;

					search(i, j);

					if (cnt > maxRoom || (cnt == maxRoom && graph[i][j] < roomNum)) {
						roomNum = graph[i][j];
						maxRoom = cnt;
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(roomNum).append(" ").append(maxRoom).append("\n");
		}

		System.out.println(sb.toString());
	}
}
