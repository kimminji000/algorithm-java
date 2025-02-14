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

		int[][] baduk = new int[20][20];

		for (int i = 1; i <= 19; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= 19; j++) {
				baduk[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		boolean flag = false;
		int count = 0;

		for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				if (baduk[i][j] != 0) {
					// 우-----------------------
					count = 0;
					for (int k = 1; k < 6; k++) {
						if (j + k <= 19 && baduk[i][j] == baduk[i][j + k]) {
							count++;
						} else {
							break;
						}
					}

					if (count == 4) {
						if (j - 1 >= 1 && baduk[i][j] == baduk[i][j - 1]) { // 왼쪽
							break;
						}
						if (j + 5 <= 19 && baduk[i][j] == baduk[i][j + 5]) { // 오른쪽
							break;
						}
						sb.append(baduk[i][j]).append("\n").append(i).append(" ").append(j);
						flag = true;
						break;
					}

					// 우하-----------------------
					count = 0;
					for (int k = 1; k < 6; k++) {
						if (i + k <= 19 && j + k <= 19 && baduk[i][j] == baduk[i + k][j + k]) {
							count++;
						} else {
							break;
						}
					}

					if (count == 4) {
						if (i - 1 >= 1 && j - 1 >= 1 && baduk[i][j] == baduk[i - 1][j - 1]) { // 왼쪽위
							continue;
						}
						if (i + 5 <= 19 && j + 5 <= 19 && baduk[i][j] == baduk[i + 5][j + 5]) { // 오른쪽아래
							continue;
						}
						sb.append(baduk[i][j]).append("\n").append(i).append(" ").append(j);
						flag = true;
						break;
					}

					// 우상-----------------------
					count = 0;
					for (int k = 1; k < 6; k++) {
						if (i - k >= 1 && j + k <= 19 && baduk[i][j] == baduk[i - k][j + k]) {
							count++;
						} else {
							break;
						}
					}

					if (count == 4) {
						if (i + 1 <= 19 && j - 1 >= 1 && baduk[i][j] == baduk[i + 1][j - 1]) { // 왼쪽아래
							continue;
						}
						if (i - 5 >= 1 && j + 5 <= 19 && baduk[i][j] == baduk[i - 5][j + 5]) { // 오른쪽위
							continue;
						}
						sb.append(baduk[i][j]).append("\n").append(i).append(" ").append(j);
						flag = true;
						break;
					}

					// 하-----------------------
					count = 0;
					for (int k = 1; k < 5; k++) {
						if (i + k <= 19 && baduk[i][j] == baduk[i + k][j]) {
							count++;
						} else {
							break;
						}
					}

					if (count == 4) {
						if (i - 1 >= 1 && baduk[i][j] == baduk[i - 1][j]) { // 위쪽
							continue;
						}
						if (i + 5 <= 19 && baduk[i][j] == baduk[i + 5][j]) { // 아래쪽
							continue;
						}
						sb.append(baduk[i][j]).append("\n").append(i).append(" ").append(j);
						flag = true;
						break;
					}
				}
				if (flag) {
					break;
				}
			}
			if (flag) {
				break;
			}
		}
		if (!flag) {
			sb.append("0");
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
