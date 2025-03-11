import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] graph;
	static int[] visited;
	static int n;

	static int bfs(int node) {
		int cnt = 0;

		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(node);
		visited[node] = 1;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int j : graph[now]) {
				if (visited[j] == 0) {
					queue.offer(j);
					visited[j] = visited[now] + 1;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			cnt += visited[i] - 1;
		}

		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];

		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			if (!graph[u].contains(v)) {
				graph[u].add(v);
			}

			if (!graph[v].contains(u)) {
				graph[v].add(u);
			}
		}

		int minPerson = 0;
		int minCnt = Integer.MAX_VALUE;

		for (int i = 1; i <= n; i++) {
			visited = new int[n + 1];

			int cnt = bfs(i);

			if (cnt < minCnt) {
				minPerson = i;
				minCnt = cnt;
			}
		}

		System.out.println(minPerson);
	}
}
