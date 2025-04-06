import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static List<Integer>[] graph1;
	static List<Integer>[] graph2;
	static boolean[] visited;

	public static void dfs(int x, List<Integer>[] graph) {
		visited[x] = true;

		for (int i = 0; i < graph[x].size(); i++) {
			int a = graph[x].get(i);

			if (!visited[a]) {
				dfs(a, graph);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());

			graph1 = new ArrayList[n + 1];
			graph2 = new ArrayList[n + 1];
			visited = new boolean[n + 1];

			for (int i = 1; i <= n; i++) {
				graph1[i] = new ArrayList<>();
				graph2[i] = new ArrayList<>();
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());

				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());

				graph1[u].add(v);
				graph2[v].add(u);
			}

			int cnt = 0;

			for (int i = 1; i <= n; i++) {
				boolean flag = true;

				dfs(i, graph1);
				dfs(i, graph2);

				for (int j = 1; j <= n; j++) {
					if (!visited[j]) {
						flag = false;
					}
				}

				if (flag) {
					cnt++;
				}

				Arrays.fill(visited, false);
			}

			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}

		System.out.println(sb.toString());
	}
}
