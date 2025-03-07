import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
	static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static int check(char board[][], int n) {
		int clickCnt = 0;

		Queue<int[]> queue = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == '.' && countLandmine(i, j, board, n) == 0) {
					clickCnt++;
					board[i][j] = '0';
					queue.offer(new int[] { i, j });
					bfs(queue, board, n);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == '.') {
					clickCnt++;
				}
			}
		}

		return clickCnt;
	}

	static int countLandmine(int x, int y, char[][] board, int n) {
		int cnt = 0;

		for (int k = 0; k < 8; k++) {
			if (isPossible(x + dx[k], y + dy[k], n) && board[x + dx[k]][y + dy[k]] == '*') {
				cnt++;
			}
		}

		return cnt;
	}

	static void bfs(Queue<int[]> queue, char[][] board, int n) {
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];

			for (int m = 0; m < 8; m++) {
				int nowX = x + dx[m];
				int nowY = y + dy[m];

				if (isPossible(nowX, nowY, n) && board[nowX][nowY] == '.') {
					board[nowX][nowY] = (char) ('0' + countLandmine(nowX, nowY, board, n));

					if (board[nowX][nowY] == '0') {
						queue.offer(new int[] { nowX, nowY });
					}
				}
			}
		}
	}

	static boolean isPossible(int x, int y, int n) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());

			char[][] board = new char[n][n];

			for (int i = 0; i < n; i++) {
				String str = br.readLine();

				for (int j = 0; j < n; j++) {
					board[i][j] = str.charAt(j);
				}
			}

			int clickCnt = check(board, n);

			sb.append("#").append(tc).append(" ").append(clickCnt).append("\n");
		}

		System.out.println(sb.toString());
	}
}
