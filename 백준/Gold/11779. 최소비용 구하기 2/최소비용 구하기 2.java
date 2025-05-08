import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static List<Node>[] graph;
	private static List<Integer> order;

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

	private static int dijkstra(int n, int start, int end) {
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		int[] prev = new int[n + 1];

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			if (curr.weight > dist[curr.vertex]) {
				continue;
			}

			for (Node next : graph[curr.vertex]) {
				if (dist[next.vertex] > dist[curr.vertex] + next.weight) {
					dist[next.vertex] = dist[curr.vertex] + next.weight;
					prev[next.vertex] = curr.vertex;
					pq.offer(new Node(next.vertex, dist[next.vertex]));
				}
			}
		}

		order = new ArrayList<>();
		for (int i = end; i != 0; i = prev[i]) {
			order.add(i);
		}
		Collections.reverse(order);

		return dist[end];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		graph = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[u].add(new Node(v, w));
		}

		st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		System.out.println(dijkstra(n, start, end));
		System.out.println(order.size());
		for (int i = 0; i < order.size(); i++) {
			System.out.print(order.get(i) + " ");
		}
	}
}
