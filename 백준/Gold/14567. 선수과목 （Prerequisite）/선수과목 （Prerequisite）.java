import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[] topologicalSort(int v, List<List<Integer>> subjects) {
		int[] inDegree = new int[v + 1];
		int[] term = new int[v + 1];

		for (int i = 1; i <= v; i++) {
			for (int j : subjects.get(i)) {
				inDegree[j]++;
			}
		}

		Queue<Integer> queue = new ArrayDeque<>();

		for (int i = 1; i <= v; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
				term[i] = 1;
			}
		}

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i : subjects.get(now)) {
				inDegree[i]--;

				if (inDegree[i] == 0) {
					queue.offer(i);
					term[i] = term[now] + 1;
				}
			}
		}

		return term;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<List<Integer>> subjects = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			subjects.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			subjects.get(a).add(b);
		}

		int[] term = topologicalSort(n, subjects);

		for (int i = 1; i <= n; i++) {
			sb.append(term[i]).append(" ");
		}

		System.out.println(sb.toString());
	}
}
