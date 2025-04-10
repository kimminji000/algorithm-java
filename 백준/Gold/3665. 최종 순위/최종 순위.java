import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static List<Integer> result;

	private static String topologicalSort(int n, List<Set<Integer>> graph) {
		int[] inDegree = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j : graph.get(i)) {
				inDegree[j]++;
			}
		}

		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}

		result = new ArrayList<>();
		while (!queue.isEmpty()) {
			if (queue.size() > 1) {
				return "?";
			}

			int now = queue.poll();
			result.add(now);

			for (int j : graph.get(now)) {
				inDegree[j]--;

				if (inDegree[j] == 0) {
					queue.offer(j);
				}
			}
		}

		if (result.size() == n) {
			return "OK";
		} else {
			return "IMPOSSIBLE";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());

			List<Set<Integer>> graph = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				graph.add(new HashSet<>());
			}

			StringTokenizer st = new StringTokenizer(br.readLine());

			int[] lastYear = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				lastYear[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= n; i++) {
				for (int j = i + 1; j <= n; j++) {
					graph.get(lastYear[i]).add(lastYear[j]);
				}
			}

			int m = Integer.parseInt(br.readLine());

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (graph.get(a).contains(b)) {
					graph.get(a).remove(b);
					graph.get(b).add(a);
				} else {
					graph.get(b).remove(a);
					graph.get(a).add(b);
				}
			}

			String flag = topologicalSort(n, graph);

			switch (flag) {
			case "OK":
				for (int i : result) {
					sb.append(i).append(" ");
				}
				break;
			case "?":
				sb.append("?");
				break;
			case "IMPOSSIBLE":
				sb.append("IMPOSSIBLE");
				break;
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}
