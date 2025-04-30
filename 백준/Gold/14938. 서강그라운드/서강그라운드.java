import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static List<Node>[] graph;
	private static int[] dist;

	private static class Node implements Comparable<Node> {
		int vertex;
		int weight;

		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	private static void dijkstra(int n, int x) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[x] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(x, 0));

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			if (dist[curr.vertex] < curr.weight) {
				continue;
			}

			for (Node next : graph[curr.vertex]) {
				if (dist[next.vertex] > dist[curr.vertex] + next.weight) {
					dist[next.vertex] = dist[curr.vertex] + next.weight;
					pq.add(new Node(next.vertex, dist[next.vertex]));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int[] item = new int[n + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}

		graph = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			graph[a].add(new Node(b, l));
			graph[b].add(new Node(a, l));
		}

		int maxCnt = 0;

		for (int i = 1; i <= n; i++) {
			dist = new int[n + 1];

			dijkstra(n, i);

			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (dist[j] <= m) {
					cnt += item[j];
				}
			}

			maxCnt = Math.max(maxCnt, cnt);
		}

		System.out.println(maxCnt);
	}
}
