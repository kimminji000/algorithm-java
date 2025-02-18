import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] graph1;
	static ArrayList<Integer>[] graph2;
	static boolean[] visited;

	public static void dfs(int x, ArrayList<Integer>[] graph) {
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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		graph1 = new ArrayList[n + 1];
		graph2 = new ArrayList[n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i <= n; i++) {
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

		sb.append(cnt).append("\n");

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}