import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[][] magnet;
	static int[] pointer;

	private static void rotate(int num, int direction) {
		pointer[num] = direction == 1 ? (pointer[num] + 7) % 8 : (pointer[num] + 1) % 8;
	}

	private static int left(int num) {
		return (pointer[num] + 6) % 8;
	}

	private static int right(int num) {
		return (pointer[num] + 2) % 8;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int k = Integer.parseInt(br.readLine());

			magnet = new int[5][8];
			pointer = new int[5];

			for (int i = 1; i <= 4; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < 8; j++) {
					magnet[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());

				int num = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());

				int[] rotation = new int[5];
				rotation[num] = direction;

				for (int j = num; j > 1; j--) {
					if (magnet[j][left(j)] != magnet[j - 1][right(j - 1)]) {
						rotation[j - 1] = -rotation[j];
					} else {
						break;
					}
				}

				for (int j = num; j < 4; j++) {
					if (magnet[j][right(j)] != magnet[j + 1][left(j + 1)]) {
						rotation[j + 1] = -rotation[j];
					} else {
						break;
					}
				}

				for (int j = 1; j <= 4; j++) {
					if (rotation[j] != 0) {
						rotate(j, rotation[j]);
					}
				}
			}

			int score = 0;

			for (int i = 1; i <= 4; i++) {
				if (magnet[i][pointer[i]] == 1) {
					score += Math.pow(2, i - 1);
				}
			}

			sb.append("#").append(tc).append(" ").append(score).append("\n");
		}

		System.out.println(sb.toString());
	}
}
