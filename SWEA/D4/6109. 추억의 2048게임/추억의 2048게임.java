import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static void move(int n, String str, int[][] graph) {
		switch (str) {
		case "left":
			for (int i = 1; i <= n; i++) {
				for (int j = 2; j <= n; j++) {
					if (graph[i][j] != 0 && graph[i][j - 1] == 0 && j >= 2) {
						graph[i][j - 1] = graph[i][j];
						graph[i][j] = 0;
						j -= 2;
					}
				}
			}

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (graph[i][j] == graph[i][j + 1]) {
						graph[i][j] = graph[i][j] * 2;
						graph[i][j + 1] = 0;
					}
				}
			}

			for (int i = 1; i <= n; i++) {
				for (int j = 2; j <= n; j++) {
					if (graph[i][j] != 0 && graph[i][j - 1] == 0 && j >= 2) {
						graph[i][j - 1] = graph[i][j];
						graph[i][j] = 0;
						j -= 2;
					}
				}
			}

			break;

		case "right":
			for (int i = 1; i <= n; i++) {
				for (int j = n - 1; j >= 1; j--) {
					if (graph[i][j] != 0 && graph[i][j + 1] == 0 && j <= n - 1) {
						graph[i][j + 1] = graph[i][j];
						graph[i][j] = 0;
						j += 2;
					}
				}
			}

			for (int i = 1; i <= n; i++) {
				for (int j = n; j >= 1; j--) {
					if (graph[i][j] == graph[i][j - 1]) {
						graph[i][j] = graph[i][j] * 2;
						graph[i][j - 1] = 0;
					}
				}
			}

			for (int i = 1; i <= n; i++) {
				for (int j = n - 1; j >= 1; j--) {
					if (graph[i][j] != 0 && graph[i][j + 1] == 0 && j <= n - 1) {
						graph[i][j + 1] = graph[i][j];
						graph[i][j] = 0;
						j += 2;
					}
				}
			}

			break;

		case "up":
			for (int j = 1; j <= n; j++) {
				for (int i = 2; i <= n; i++) {
					if (graph[i][j] != 0 && graph[i - 1][j] == 0 && i >= 2) {
						graph[i - 1][j] = graph[i][j];
						graph[i][j] = 0;
						i -= 2;
					}
				}
			}

			for (int j = 1; j <= n; j++) {
				for (int i = 1; i <= n; i++) {
					if (graph[i][j] == graph[i + 1][j]) {
						graph[i][j] = graph[i][j] * 2;
						graph[i + 1][j] = 0;
					}
				}
			}

			for (int j = 1; j <= n; j++) {
				for (int i = 2; i <= n; i++) {
					if (graph[i][j] != 0 && graph[i - 1][j] == 0 && i >= 2) {
						graph[i - 1][j] = graph[i][j];
						graph[i][j] = 0;
						i -= 2;
					}
				}
			}

			break;

		case "down":
			for (int j = 1; j <= n; j++) {
				for (int i = n - 1; i >= 1; i--) {
					if (graph[i][j] != 0 && graph[i + 1][j] == 0 && i <= n - 1) {
						graph[i + 1][j] = graph[i][j];
						graph[i][j] = 0;
						i += 2;
					}
				}
			}

			for (int j = 1; j <= n; j++) {
				for (int i = n; i >= 1; i--) {
					if (graph[i][j] == graph[i - 1][j]) {
						graph[i][j] = graph[i][j] * 2;
						graph[i - 1][j] = 0;
					}
				}
			}

			for (int j = 1; j <= n; j++) {
				for (int i = n - 1; i >= 1; i--) {
					if (graph[i][j] != 0 && graph[i + 1][j] == 0 && i <= n - 1) {
						graph[i + 1][j] = graph[i][j];
						graph[i][j] = 0;
						i += 2;
					}
				}
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

			int n = Integer.parseInt(st.nextToken());
			String str = st.nextToken();

			int[][] graph = new int[n + 2][n + 2];

			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 1; j <= n; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			move(n, str, graph);

			sb.append("#").append(tc).append("\n");

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					sb.append(graph[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}
