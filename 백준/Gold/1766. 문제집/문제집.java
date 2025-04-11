import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static List<Integer> topologicalSort(int n, List<List<Integer>> graph) {
		int[] inDegree = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j : graph.get(i)) {
				inDegree[j]++;
			}
		}

		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}

		List<Integer> result = new ArrayList<>();

		while (!queue.isEmpty()) {
			int now = queue.poll();
			result.add(now);

			for (int i : graph.get(now)) {
				inDegree[i]--;

				if (inDegree[i] == 0) {
					queue.offer(i);
				}
			}
		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
		}

		List<Integer> result = topologicalSort(n, graph);

		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i)).append(" ");
		}

		System.out.println(sb.toString());
	}
}
