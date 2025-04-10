import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<Integer> result;

	private static String topologicalSort(int n, List<List<Integer>> graph) {
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

		if (queue.isEmpty()) {
			return "IMPOSSIBLE";
		}

		result = new ArrayList<>();
		while (!queue.isEmpty()) {
			if (queue.size() != 1) {
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
			return "true";
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

			List<List<Integer>> graph = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				graph.add(new ArrayList<>());
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

				if (graph.get(a).contains(Integer.valueOf(b))) {
					graph.get(a).remove(Integer.valueOf(b));
					graph.get(b).add(a);
				} else {
					graph.get(b).remove(Integer.valueOf(a));
					graph.get(a).add(b);
				}
			}

			String flag = topologicalSort(n, graph);

			if (flag.equals("true")) {
				for (int i : result) {
					sb.append(i).append(" ");
				}
			} else if (flag.equals("?")) {
				sb.append("?");
			} else if (flag.equals("IMPOSSIBLE")) {
				sb.append("IMPOSSIBLE");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}
