import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int cnt;
	static int[] students;
	static boolean[] visited;
	static boolean[] finished;

	private static void dfs(int x) {
		visited[x] = true;

		int next = students[x];

		if (!visited[next]) {
			dfs(next);
		} else if (!finished[next]) {
			cnt++;
			while (next != x) {
				cnt++;
				next = students[next];
			}
		}

		finished[x] = true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());

			students = new int[n + 1];
			visited = new boolean[n + 1];
			finished = new boolean[n + 1];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				students[i] = Integer.parseInt(st.nextToken());
			}

			cnt = 0;

			for (int i = 1; i <= n; i++) {
				if (!visited[i]) {
					dfs(i);
				}
			}

			System.out.println(n - cnt);
		}
	}
}
