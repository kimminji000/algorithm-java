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
	private static int[] dist;
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
		dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));

		order = new ArrayList<>();
		int[] parent = new int[n + 1];

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			if (curr.weight > dist[curr.vertex]) {
				continue;
			}

			for (Node next : graph[curr.vertex]) {
				if (dist[next.vertex] > dist[curr.vertex] + next.weight) {
					dist[next.vertex] = dist[curr.vertex] + next.weight;
					pq.offer(new Node(next.vertex, dist[next.vertex]));
					parent[next.vertex] = curr.vertex;
				}
			}
		}

		int check = end;
		order.add(end);
		while (check != start) {
			order.add(parent[check]);
			check = parent[check];
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

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph[a].add(new Node(b, c));
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
