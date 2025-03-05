import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Node>[] graph;
	static int[] dist;

	static class Node implements Comparable<Node> {
		int index;
		int cost;

		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}

	static void dijkstra(int n) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[n] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();

		pq.add(new Node(n, 0));

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			if (now.cost > dist[now.index]) {
				continue;
			}

			for (Node next : graph[now.index]) {
				if (dist[now.index] + next.cost < dist[next.index]) {
					dist[next.index] = dist[now.index] + next.cost;
					pq.add(new Node(next.index, dist[next.index]));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int vcnt = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		int k = Integer.parseInt(br.readLine());

		graph = new ArrayList[vcnt + 1];
		dist = new int[vcnt + 1];

		for (int i = 0; i <= vcnt; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[u].add(new Node(v, w));
		}

		dijkstra(k);

		for (int i = 1; i <= vcnt; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				sb.append("INF").append("\n");
			} else {
				sb.append(dist[i]).append("\n");
			}
		}

		System.out.println(sb.toString());

		br.close();
	}
}
