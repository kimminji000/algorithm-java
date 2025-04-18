import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] board;
	static boolean[] alpha;
	static int r, c, maxCnt;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	private static void dfs(int x, int y, int cnt) {
		alpha[board[x][y] - 'A'] = true;
		maxCnt = Math.max(cnt, maxCnt);

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if ((nx >= 0 && nx < r && ny >= 0 && ny < c) && !alpha[board[nx][ny] - 'A']) {
				dfs(nx, ny, cnt + 1);
			}
		}

		alpha[board[x][y] - 'A'] = false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		board = new char[r][c];
		alpha = new boolean[26];

		for (int i = 0; i < r; i++) {
			String str = br.readLine();

			for (int j = 0; j < c; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		dfs(0, 0, 1);

		System.out.println(maxCnt);
	}
}
