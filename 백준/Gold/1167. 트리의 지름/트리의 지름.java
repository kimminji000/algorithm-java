import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Node>[] graph;
	static boolean[] visited;
	static int maxLength, farthestNode;

	static class Node {
		int vertex;
		int weight;

		public Node(int vertex, int weight) {
			super();
			this.vertex = vertex;
			this.weight = weight;
		}
	}

	private static void dfs(int curr, int length) {
		visited[curr] = true;

		if (length > maxLength) {
			maxLength = length;
			farthestNode = curr;
		}

		for (Node next : graph[curr]) {
			if (!visited[next.vertex]) {
				dfs(next.vertex, length + next.weight);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int v = Integer.parseInt(br.readLine());

		graph = new ArrayList[v + 1];
		for (int i = 1; i <= v; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < v; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());

			while (true) {
				int b = Integer.parseInt(st.nextToken());
				if (b == -1) {
					break;
				}
				int c = Integer.parseInt(st.nextToken());

				graph[a].add(new Node(b, c));
			}
		}

		// 1에서 제일 먼거
		visited = new boolean[v + 1];
		dfs(1, 0);

		// 제일 먼거에서 제일 먼거
		maxLength = 0;
		Arrays.fill(visited, false);
		dfs(farthestNode, 0);

		System.out.println(maxLength);
	}
}
