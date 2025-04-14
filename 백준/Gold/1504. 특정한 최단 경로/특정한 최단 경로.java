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
		int cost;

		public Node(int vertex, int cost) {
			super();
			this.vertex = vertex;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	private static int dijkstra(int node1, int node2) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[node1] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(node1, 0));

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (now.cost > dist[now.vertex]) {
				continue;
			}

			for (Node next : graph[now.vertex]) {
				if (dist[now.vertex] + next.cost < dist[next.vertex]) {
					dist[next.vertex] = dist[now.vertex] + next.cost;
					pq.add(new Node(next.vertex, dist[next.vertex]));
				}
			}
		}

		return dist[node2];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];
		dist = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[a].add(new Node(b, c));
			graph[b].add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		int cost1 = dijkstra(1, v1);
		int cost2 = dijkstra(v1, v2);
		int cost3 = dijkstra(v2, n);
		int cost4 = dijkstra(1, v2);
		int cost5 = dijkstra(v2, v1);
		int cost6 = dijkstra(v1, n);

		long costSum1 = (cost1 == Integer.MAX_VALUE || cost2 == Integer.MAX_VALUE || cost3 == Integer.MAX_VALUE)
				? Integer.MAX_VALUE
				: (long) cost1 + cost2 + cost3;
		long costSum2 = (cost4 == Integer.MAX_VALUE || cost5 == Integer.MAX_VALUE || cost6 == Integer.MAX_VALUE)
				? Integer.MAX_VALUE
				: (long) cost4 + cost5 + cost6;

		if (costSum1 == Integer.MAX_VALUE && costSum2 == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(Math.min(costSum1, costSum2));
		}
	}
}
