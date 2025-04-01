import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static Set<String> perms;
	static int[] perm;
	static int[] num;
	static boolean[] visited;

	static void permutation(int depth, int n, int r) {
		if (depth == r) {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < r; i++) {
				sb.append(perm[i]).append(" ");
			}

			perms.add(sb.toString());
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				perm[depth] = num[i];
				permutation(depth + 1, n, r);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		num = new int[n];
		visited = new boolean[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);

		perms = new LinkedHashSet<>();
		perm = new int[m];

		permutation(0, n, m);

		for (String str : perms) {
			st = new StringTokenizer(str);
			for (int j = 0; j < m; j++) {
				sb.append(st.nextToken()).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}
