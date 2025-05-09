import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
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

	private static void dijkstra(List<Node>[] graph, int[] dist, int x) {
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
		int x = Integer.parseInt(st.nextToken());

		List<Node>[] graph = new ArrayList[n + 1];
		List<Node>[] rGraph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
			rGraph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			graph[start].add(new Node(end, time));
			rGraph[end].add(new Node(start, time));
		}

		int[] goDist = new int[n + 1];
		int[] backDist = new int[n + 1];

		dijkstra(rGraph, goDist, x);
		dijkstra(graph, backDist, x);

		int maxTime = 0;
		for (int i = 1; i <= n; i++) {
			maxTime = Math.max(maxTime, goDist[i] + backDist[i]);
		}

		System.out.println(maxTime);
	}
}
