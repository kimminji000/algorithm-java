import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char[][] board = new char[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();

			for (int j = 0; j < m; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		int minCnt = n * m;

		for (int i = 0; i <= n - 8; i++) {
			for (int j = 0; j <= m - 8; j++) {

				int cnt = 0, ptr = 0;
				for (int x = 0; x < 8; x++) {
					for (int y = 0; y < 8; y++) {
						if (ptr % 2 == 0) {
							if (board[i + x][j + y] != 'W')
								cnt++;
							ptr++;
						} else {
							if (board[i + x][j + y] != 'B')
								cnt++;
							ptr++;
						}
					}
					ptr++;
				}
				minCnt = Math.min(minCnt, cnt);

				cnt = 0;
				ptr = 1;
				for (int x = 0; x < 8; x++) {
					for (int y = 0; y < 8; y++) {
						if (ptr % 2 == 0) {
							if (board[i + x][j + y] != 'W')
								cnt++;
							ptr++;
						} else {
							if (board[i + x][j + y] != 'B')
								cnt++;
							ptr++;
						}
					}
					ptr++;
				}
				minCnt = Math.min(minCnt, cnt);
			}
		}

		sb.append(minCnt);

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
