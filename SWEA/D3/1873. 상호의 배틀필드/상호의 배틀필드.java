import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int h;
	static int w;
	static int x;
	static int y;

	static void move(char command, char[][] map) {
		switch (command) {
		case 'U':
			if (x - 1 >= 0 && map[x - 1][y] == '.') {
				map[x][y] = '.';
				x--;
			}
			map[x][y] = '^';

			break;

		case 'D':
			if (x + 1 < h && map[x + 1][y] == '.') {
				map[x][y] = '.';
				x++;
			}
			map[x][y] = 'v';

			break;

		case 'L':
			if (y - 1 >= 0 && map[x][y - 1] == '.') {
				map[x][y] = '.';
				y--;
			}
			map[x][y] = '<';

			break;

		case 'R':
			if (y + 1 < w && map[x][y + 1] == '.') {
				map[x][y] = '.';
				y++;
			}
			map[x][y] = '>';

			break;

		case 'S':
			int a = x;
			int b = y;

			switch (map[a][b]) {
			case '^':
				while (a > 0) {
					a--;

					if (map[a][b] == '*') {
						map[a][b] = '.';
						break;
					}

					if (map[a][b] == '#') {
						break;
					}
				}

				break;

			case 'v':
				while (a < h - 1) {
					a++;

					if (map[a][b] == '*') {
						map[a][b] = '.';
						break;
					}

					if (map[a][b] == '#') {
						break;
					}
				}

				break;

			case '<':
				while (b > 0) {
					b--;

					if (map[a][b] == '*') {
						map[a][b] = '.';
						break;
					}

					if (map[a][b] == '#') {
						break;
					}
				}

				break;

			case '>':
				while (b < w - 1) {
					b++;

					if (map[a][b] == '*') {
						map[a][b] = '.';
						break;
					}

					if (map[a][b] == '#') {
						break;
					}
				}

				break;
			}

			break;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());

			char[][] map = new char[h][w];

			for (int i = 0; i < h; i++) {
				String str = br.readLine();

				for (int j = 0; j < w; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						x = i;
						y = j;
					}
				}
			}

			int n = Integer.parseInt(br.readLine());
			String command = br.readLine();

			for (int i = 0; i < n; i++) {
				move(command.charAt(i), map);
			}

			sb.append("#").append(tc).append(" ");

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}
