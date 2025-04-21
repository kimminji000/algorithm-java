import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<List<Node>> graph;
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

		for (Node next : graph.get(curr)) {
			if (!visited[next.vertex]) {
				dfs(next.vertex, length + next.weight);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}

		// 1단계: 아무 노드(보통 1번)에서 가장 먼 노드 찾기
		visited = new boolean[n + 1];
		maxLength = 0;
		dfs(1, 0);

		// 2단계: 찾은 노드에서 다시 DFS해서 트리 지름 구하기
		visited = new boolean[n + 1];
		maxLength = 0;
		dfs(farthestNode, 0);

		System.out.println(maxLength);
	}
}
