import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static int[] perm;
	static StringBuilder sb;

	public static void permutation(int depth, int n, int r) {
		if (depth == r) {
			for (int i = 0; i < r; i++) {
				sb.append(perm[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				perm[depth] = i;
				permutation(depth + 1, n, r);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		perm = new int[m];
		visited = new boolean[n + 1];

		permutation(0, n, m);

		System.out.println(sb.toString());
		br.close();
	}
}
