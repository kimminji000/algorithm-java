import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static int[] parent;
	static List<Integer>[] graph;

	static void dfs(int num) {
		visited[num] = true;

		for (int i : graph[num]) {
			if (!visited[i]) {
				parent[i] = num;
				dfs(i);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		visited = new boolean[n + 1];
		parent = new int[n + 1];
		graph = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u].add(v);
			graph[v].add(u);
		}

		dfs(1);

		for (int i = 2; i <= n; i++) {
			System.out.println(parent[i]);
		}
	}
}
