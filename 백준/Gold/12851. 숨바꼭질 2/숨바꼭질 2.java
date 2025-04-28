import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[] time;
	private static int minTime;
	private static int cnt;

	private static void bfs(int n, int k) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(n);
		time[n] = 1;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			if (now == k) {
				if (minTime > time[now]) {
					minTime = time[now];
					cnt = 1;
				} else if (minTime == time[now]) {
					cnt++;
				}
			}

			if (minTime < time[now]) {
				return;
			}

			int[] nextPos = { now - 1, now + 1, now * 2 };
			for (int next : nextPos) {
				if (next >= 0 && next <= 100000) {
					if (time[next] == 0 || time[next] == time[now] + 1) {
						queue.offer(next);
						time[next] = time[now] + 1;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		time = new int[100001];
		minTime = Integer.MAX_VALUE;
		cnt = 0;

		bfs(n, k);

		System.out.println(minTime - 1);
		System.out.println(cnt);
	}
}
