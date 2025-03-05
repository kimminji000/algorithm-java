import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int cnt;
	static boolean[] graph;
	static boolean[] slash;
	static boolean[] bslash;

	static void setQueen(int row) {
		if (row == n) {
			cnt++;
			return;
		}

		for (int col = 0; col < n; col++) {
			if (!isPossible(row, col)) {
				continue;
			}

			graph[col] = slash[row + col] = bslash[row - col + n - 1] = true;
			setQueen(row + 1);
			graph[col] = slash[row + col] = bslash[row - col + n - 1] = false;
		}
	}

	static boolean isPossible(int row, int col) {
		return !graph[col] && !slash[row + col] && !bslash[row - col + n - 1];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		graph = new boolean[n];
		slash = new boolean[2 * n - 1]; // /
		bslash = new boolean[2 * n - 1]; // \

		cnt = 0;
		setQueen(0);

		System.out.println(cnt);
	}
}
