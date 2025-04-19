import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<Integer> graph[];
	static int[] time;

	private static int topologicalSort(int n) {
		int[] sumTime = new int[n + 1];
		int[] inDegree = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			sumTime[i] = time[i];

			for (int next : graph[i]) {
				inDegree[next]++;
			}
		}

		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int next : graph[now]) {
				inDegree[next]--;

				sumTime[next] = Math.max(sumTime[next], sumTime[now] + time[next]);

				if (inDegree[next] == 0) {
					queue.offer(next);
				}
			}
		}

		int max = 0;

		for (int i = 1; i <= n; i++) {
			max = Math.max(max, sumTime[i]);
		}

		return max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		time = new int[n + 1];

		graph = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			time[i] = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			for (int j = 0; j < k; j++) {
				graph[Integer.parseInt(st.nextToken())].add(i);
			}
		}

		int ans = topologicalSort(n);

		System.out.println(ans);
	}
}
