import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	static int cnt;
	static int[] sequence;

	public static void dfs(int r) {
		if (visited[r]) {
			return;
		}

		visited[r] = true;
		cnt++;
		sequence[r] = cnt;

		for (int x : graph[r]) {
			if (!visited[x]) {
				dfs(x);
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
		int r = Integer.parseInt(st.nextToken());

		visited = new boolean[n + 1];
		graph = new ArrayList[n + 1];
		sequence = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u].add(v);
			graph[v].add(u);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(graph[i]);
			Collections.reverse(graph[i]);
		}

		cnt = 0;
		dfs(r);

		for (int i = 1; i <= n; i++) {
			sb.append(sequence[i]).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
