import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int cnt, s;
	static int[] num;
	static boolean[] visited;

	private static void combi(int n, int r, int start, int depth) {
		if (depth == r) {
			int sum = 0;

			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					sum += num[i];
				}
			}

			if (sum == s) {
				cnt++;
			}

			return;
		}

		for (int i = start; i < n; i++) {
			visited[i] = true;
			combi(n, r, i + 1, depth + 1);
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		num = new int[n];
		visited = new boolean[n];

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
