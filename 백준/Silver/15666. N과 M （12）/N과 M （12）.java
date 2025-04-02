import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<int[]> perms;
	static int[] perm;
	static int[] num;

	static void combination(int start, int depth, int n, int r) {
		if (depth == r) {
			perms.add(perm.clone());
			return;
		}

		for (int i = start; i < n; i++) {
			perm[depth] = num[i];
			combination(i, depth + 1, n, r);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] input = new int[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		num = Arrays.stream(input).distinct().toArray();
		Arrays.sort(num);

		perms = new ArrayList<>();
		perm = new int[m];

		combination(0, 0, num.length, m);

		for (int[] i : perms) {
			for (int j = 0; j < m; j++) {
				sb.append(i[j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}
