import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int minLength;
	static int[] comb;
	static List<int[]> house;
	static List<int[]> chicken;

	static void combination(int start, int depth, int n, int r) {
		if (depth == r) {
			int sum = 0;

			for (int i = 0; i < house.size(); i++) {
				int length = Integer.MAX_VALUE;

				int[] nowHouse = house.get(i);
				int houseX = nowHouse[0];
				int houseY = nowHouse[1];

				for (int j = 0; j < r; j++) {
					int[] nowChicken = chicken.get(comb[j]);
					int chickenX = nowChicken[0];
					int chickenY = nowChicken[1];

					length = Math.min(length, Math.abs(houseX - chickenX) + Math.abs(houseY - chickenY));
				}

				sum += length;

				if (sum > minLength) {
					return;
				}
			}

			minLength = sum;
			return;
		}

		for (int i = start; i < n; i++) {
			comb[depth] = i;
			combination(i + 1, depth + 1, n, r);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][n];
		house = new ArrayList<>();
		chicken = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 1) {
					house.add(new int[] { i, j });
				}

				if (map[i][j] == 2) {
					chicken.add(new int[] { i, j });
				}
			}
		}

		comb = new int[m];
		minLength = Integer.MAX_VALUE;

		combination(0, 0, chicken.size(), m);

		System.out.println(minLength);
	}
}
