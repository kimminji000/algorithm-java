import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] num;
	static int[] comb;

	private static void combination(int start, int depth, int n, int r) {
		if (depth == r) {
			int sum = 0;

			for (int i = 0; i < 7; i++) {
				sum += num[comb[i]];
			}

			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(num[comb[i]]);
				}
			}

			return;
		}

		for (int i = start; i < n; i++) {
			comb[depth] = i;
			combination(i + 1, depth + 1, n, r);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		num = new int[9];

		for (int i = 0; i < 9; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		comb = new int[7];
		combination(0, 0, 9, 7);
	}
}
