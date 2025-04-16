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

	private static void dfs(String num, int cnt) {
		if (!isPrime(Integer.parseInt(num))) {
			return;
		}

		if (cnt == n) {
			sb.append(num).append("\n");
			return;
		}

		if (cnt < n) {
			for (int j = 1; j <= 9; j++) {
				dfs(num + Integer.toString(j), cnt + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());

		dfs("2", 1);
		dfs("3", 1);
		dfs("5", 1);
		dfs("7", 1);

		System.out.println(sb.toString());
	}
}
