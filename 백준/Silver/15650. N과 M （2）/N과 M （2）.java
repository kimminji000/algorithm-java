import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<int[]> combs;
	static int[] comb;

	static void combination(int start, int depth, int n, int r) {
		if (depth == r) {
			combs.add(comb.clone());
			return;
		}

		for (int i = start; i < n; i++) {
			comb[depth] = i + 1;
			combination(i + 1, depth + 1, n, r);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		combs = new ArrayList<>();
		comb = new int[m];

		combination(0, 0, n, m);

		for (int[] i : combs) {
			for (int j = 0; j < m; j++) {
				sb.append(i[j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}
