import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static boolean[] column;
	static boolean[] slash;
	static boolean[] bslash;
	static int n, cnt = 0;

	private static void setQueen(int r) {
		if (r == n) {
			cnt++;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!column[i] && !slash[r + i] && !bslash[r - i + n - 1]) {
				column[i] = slash[r + i] = bslash[r - i + n - 1] = true;

				setQueen(r + 1);

				column[i] = slash[r + i] = bslash[r - i + n - 1] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		column = new boolean[n];
		slash = new boolean[2 * n - 1];
		bslash = new boolean[2 * n - 1];

		setQueen(0);

		System.out.println(cnt);
	}
}
