import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 10; i++) {
			int t = Integer.parseInt(br.readLine());

			int[][] ladder = new int[100][100];
			int x = 0, y = 0;

			for (int a = 0; a < 100; a++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int b = 0; b < 100; b++) {
					ladder[a][b] = Integer.parseInt(st.nextToken());
					if (ladder[a][b] == 2) {
						x = a;
						y = b;
					}
				}
			}

			while (x > 0) {
				if (y - 1 >= 0 && ladder[x][y - 1] == 1) {
					while (y - 1 >= 0 && ladder[x][y - 1] == 1) {
						y--;
					}
					x--;
				} else if (y + 1 < 100 && ladder[x][y + 1] == 1) {
					while (y + 1 < 100 && ladder[x][y + 1] == 1) {
						y++;
					}
					x--;
				} else {
					x--;
				}
			}

			sb.append("#").append(t).append(" ").append(y).append("\n");
		}

		System.out.println(sb.toString());

		br.close();
	}
}
