import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] visited;
	static int k;

	public static void bfs(int x) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(x);
		visited[x] = 1;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			if (now == k) {
				return;
			}

			if (now - 1 >= 0 && visited[now - 1] == 0) {
				visited[now - 1] = visited[now] + 1;
				queue.add(now - 1);
			}

			if (now + 1 <= 100000 && visited[now + 1] == 0) {
				visited[now + 1] = visited[now] + 1;
				queue.add(now + 1);
			}

			if (2 * now <= 100000 && visited[2 * now] == 0) {
				visited[now * 2] = visited[now] + 1;
				queue.add(2 * now);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		visited = new int[100001];

		bfs(n);

		sb.append(visited[k] - 1);

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
