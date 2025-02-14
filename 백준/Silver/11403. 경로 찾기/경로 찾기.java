import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		visited = new boolean[n];
		graph = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<Integer>();

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					graph[i].add(j);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			visited = new boolean[n];

			int depth = 0;
			dfs(i, depth);

			for (int j = 0; j < n; j++) {
				if (visited[j]) {
					sb.append(1).append(" ");
				} else {
					sb.append(0).append(" ");
				}
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

	static void dfs(int x, int depth) {
		if (visited[x]) {
			return;
		}

		if (depth != 0) {
			visited[x] = true;
		}
		
		depth++;

		for (int i : graph[x]) {
			dfs(i, depth);
		}
	}
}
