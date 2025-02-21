import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[][] seats = new int[n][n]; // 자리
		int[][] student = new int[n * n + 1][4]; // 좋아하는 학생

		int[] dx = new int[] { -1, 1, 0, 0 };
		int[] dy = new int[] { 0, 0, -1, 1 };

		for (int i = 0; i < n * n; i++) { // 학생 N * N명
			st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken());

			for (int j = 0; j < 4; j++) {
				student[num][j] = Integer.parseInt(st.nextToken()); // 좋아하는 학생들
			}

			int bestX = -1; // 최적 x 좌표
			int bestY = -1; // 최적 y 좌표
			int bestLike = -1; // 최적자리 인접한 칸에 좋아하는 학생 수
			int bestBlank = -1; // 최적자리 인접한 칸에 빈자리 수

			for (int x = 0; x < n; x++) { // 모든 칸 돌기
				for (int y = 0; y < n; y++) {
					if (seats[x][y] == 0) { // 빈칸만 확인
						int like = 0; // 인접한 칸에 좋아하는 학생 수
						int blank = 0; // 인접한 칸에 빈칸 수

						for (int l = 0; l < 4; l++) { // 상하좌우 확인
							int nowX = x + dx[l];
							int nowY = y + dy[l];

							if (nowX >= 0 && nowX < n && nowY >= 0 && nowY < n) {
								if (seats[nowX][nowY] == 0) { // 칸이 비어있을 떄
									blank++;
								} else {
									for (int m = 0; m < 4; m++) { // 좋아하는 학생인지 확인
										if (seats[nowX][nowY] == student[num][m]) {
											like++;
										}
									}
								}
							}
						}

						// 인접한 칸에 좋아하는 학생이 더 많을때, 같다면 빈칸이 많을때 갱신
						if (like > bestLike || (like == bestLike && blank > bestBlank)) {
							bestX = x;
							bestY = y;
							bestLike = like;
							bestBlank = blank;
						}
					}
				}
			}

			seats[bestX][bestY] = num;
		}

		int sum = 0; // 만족도

		for (int x = 0; x < n; x++) { // 모든 칸 돌기
			for (int y = 0; y < n; y++) {
				int like = 0; // 인접한 칸에 좋아하는 학생 수

				for (int l = 0; l < 4; l++) { // 상하좌우 확인
					int nowX = x + dx[l];
					int nowY = y + dy[l];

					if (nowX >= 0 && nowX < n && nowY >= 0 && nowY < n) {
						for (int m = 0; m < 4; m++) { // 좋아하는 학생인지 확인
							if (seats[nowX][nowY] == student[seats[x][y]][m]) {
								like++;
							}
						}
					}
				}

				if (like == 1) {
					sum += 1;
				} else if (like == 2) {
					sum += 10;
				} else if (like == 3) {
					sum += 100;
				} else if (like == 4) {
					sum += 1000;
				}
			}
		}

		System.out.println(sum);
		br.close();
	}
}
