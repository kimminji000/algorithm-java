import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static char[][] map;
	static boolean[][] visited;
	static int r, c;
	static int[] dx = { -1, 0, 1 };

	private static boolean dfs(int x, int y) {
		visited[x][y] = true;

		if (y == c - 1) {
			return true;
		}

		for (int i = 0; i < 3; i++) {
			int nextX = x + dx[i];
			int nextY = y + 1;

			if (isInRange(nextX, nextY, r, c) && map[nextX][nextY] == '.' && !visited[nextX][nextY]) {
				if (dfs(nextX, nextY)) {
					return true;
				}
			}
		}

		return false;
	}

	private static boolean isInRange(int x, int y, int r, int c) {
		return x >= 0 && x < r && y >= 0 && y < c;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		map = new char[r][c];
		visited = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			String str = br.readLine();

			for (int j = 0; j < c; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < r; i++) {
			dfs(i, 0);
		}

		int cnt = 0;
		for (int i = 0; i < r; i++) {
			if (visited[i][c - 1]) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
