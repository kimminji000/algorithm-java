import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int cnt, s, sum = 0;
	static int[] num;

	private static void combi(int n, int r, int start, int depth) {
		if (depth == r) {
			if (sum == s) {
				cnt++;
			}

			return;
		}

		for (int i = start; i < n; i++) {
			sum += num[i];
			combi(n, r, i + 1, depth + 1);
			sum -= num[i];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		num = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			combi(n, i, 0, 0);
		}

		System.out.println(cnt);
	}
}
