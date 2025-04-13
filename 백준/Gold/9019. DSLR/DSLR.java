import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Pair {
		int num;
		String command;

		public Pair(int num, String command) {
			super();
			this.num = num;
			this.command = command;
		}
	}

	private static String bfs(int a, int b) {
		Queue<Pair> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[10000];

		queue.offer(new Pair(a, ""));
		visited[a] = true;

		while (!queue.isEmpty()) {
			Pair now = queue.poll();

			if (now.num == b) {
				return now.command;
			}

			int d = now.num * 2 % 10000;
			if (!visited[d]) {
				queue.offer(new Pair(d, now.command + "D"));
				visited[d] = true;
			}

			int s = now.num == 0 ? 9999 : now.num - 1;
			if (!visited[s]) {
				queue.offer(new Pair(s, now.command + "S"));
				visited[s] = true;
			}

			int l = doL(now.num);
			if (!visited[l]) {
				queue.offer(new Pair(l, now.command + "L"));
				visited[l] = true;
			}

			int r = doR(now.num);
			if (!visited[r]) {
				queue.offer(new Pair(r, now.command + "R"));
				visited[r] = true;
			}
		}

		return null;
	}

	private static int doL(int num) {
		int thousand = num / 1000;
		int other = num % 1000;
		return other * 10 + thousand;
	}

	private static int doR(int num) {
		int one = num % 10;
		int other = num / 10;
		return one * 1000 + other;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			String command = bfs(a, b);

			sb.append(command).append("\n");
		}

		System.out.println(sb.toString());
	}
}
