import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static long bfs(int a, int b) {
		Queue<long[]> queue = new ArrayDeque<>();

		if (a == b) {
			return 1;
		}

		queue.offer(new long[] { a, 1 });

		while (!queue.isEmpty()) {
			long[] now = queue.poll();
			long nowNum = now[0];
			long nowCnt = now[1];

			if (nowNum * 2 == b || nowNum * 10 + 1 == b) {
				return nowCnt + 1;
			}

			if (nowNum * 2 < b) {
				queue.offer(new long[] { nowNum * 2, nowCnt + 1 });
			}

			if (nowNum * 10 + 1 < b) {
				queue.offer(new long[] { (nowNum * 10) + 1, nowCnt + 1 });
			}
		}

		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		long answer = bfs(a, b);
		System.out.println(answer);
	}
}
