import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	static ArrayList<Integer> sequenceDfs;
	static ArrayList<Integer> sequenceBfs;

	public static void dfs(int r) {
		if (visited[r]) {
			return;
		}

		visited[r] = true;
		sequenceDfs.add(r);

		for (int x : graph[r]) {
			dfs(x);
		}
	}

	public static void bfs(int r) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(r);
		visited[r] = true;

		while (!queue.isEmpty()) {
			int now = queue.poll();
			sequenceBfs.add(now);

			for (int x : graph[now]) {
				if (!visited[x]) {
					visited[x] = true;
					queue.add(x);
				}
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
		int v = Integer.parseInt(st.nextToken());

		visited = new boolean[n + 1];
		graph = new ArrayList[n + 1];
		sequenceDfs = new ArrayList<Integer>();
		sequenceBfs = new ArrayList<Integer>();

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			graph[b].add(a);
		}

		for (int i = 1; i <= n; i++) {
			Collections.sort(graph[i]);
		}

		dfs(v);

		visited = new boolean[n + 1];

		bfs(v);

		for (int i = 0; i < sequenceDfs.size(); i++) {
			sb.append(sequenceDfs.get(i)).append(" ");
		}

		sb.append("\n");

		for (int i = 0; i < sequenceBfs.size(); i++) {
			sb.append(sequenceBfs.get(i)).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
