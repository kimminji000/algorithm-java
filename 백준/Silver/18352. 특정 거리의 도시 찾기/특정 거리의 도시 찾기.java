import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dist;
	static boolean[] visited;
	static List<Integer>[] graph;

	static void bfs(int n, int k) {
		Queue<Integer> queue = new ArrayDeque<>();

		queue.add(n);
		visited[n] = true;
		dist[n] = 0;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			if (dist[now] >= k) {
				break;
			}

			for (int i = 0; i < graph[now].size(); i++) {
				if (!visited[graph[now].get(i)]) {
					queue.add(graph[now].get(i));
					visited[graph[now].get(i)] = true;
					dist[graph[now].get(i)] = dist[now] + 1;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		visited = new boolean[n + 1];
		graph = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
		}

		bfs(x, k);

		boolean flag = true;

		for (int i = 1; i <= n; i++) {
			if (dist[i] == k) {
				flag = false;
				sb.append(i).append("\n");
			}
		}

		if (flag) {
			System.out.println(-1);
		} else {
			System.out.println(sb.toString());
		}

		br.close();
	}
}
