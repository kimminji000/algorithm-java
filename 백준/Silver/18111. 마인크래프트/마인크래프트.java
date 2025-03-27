import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int[][] ground = new int[n][m];
		int high = 256, low = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++) {
				ground[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int minTime = Integer.MAX_VALUE, height = 0;

		for (int i = high; i >= low; i--) {
			int time = 0, block = b;

			for (int x = 0; x < n; x++) {
				for (int y = 0; y < m; y++) {
					if (ground[x][y] > i) {
						int diff = ground[x][y] - i;

						block += diff;
						time += 2 * diff;
					}

					if (ground[x][y] < i) {
						int diff = i - ground[x][y];

						block -= diff;
						time += 1 * diff;
					}
				}
			}

			if (block >= 0 && time < minTime) {
				minTime = time;
				height = i;
			}
		}

		System.out.println(minTime + " " + height);
	}
}
