import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb;
	static int n;

	private static boolean isPrime(int num) {
		if (num == 1) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}

	private static void dfs(int num, int depth) {
		if (depth == n) {
			sb.append(num).append("\n");
			return;
		}

		for (int i = 1; i <= 9; i += 2) {
			int next = num * 10 + i;
			if (isPrime(next)) {
				dfs(next, depth + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());

		int[] start = { 2, 3, 5, 7 };
		for (int num : start) {
			dfs(num, 1);
		}

		System.out.println(sb.toString());
	}
}
