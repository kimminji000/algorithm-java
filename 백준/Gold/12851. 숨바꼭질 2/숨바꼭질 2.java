import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int minTime;
	static int cnt;

	private static int[] bfs(int n, int k) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(n);
		int[] time = new int[100001];
		time[n] = 1;

		minTime = Integer.MAX_VALUE;
		cnt = 0;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			if (now == k) {
				minTime = time[now];
				cnt++;
			}

			if (minTime < time[now]) {
				return new int[] { minTime, cnt };

			}

			int[] nextPos = { now - 1, now + 1, now * 2 };

			for (int next : nextPos) {
				if (next >= 0 && next <= 100000) {
					if (time[next] == time[now] + 1) { // 이전에 최단거리로 방문한 적 있음
						queue.offer(next);
					}

					if (time[next] == 0) { // 방문한 적 없음
						queue.offer(next);
						time[next] = time[now] + 1;
					}
				}
			}
		}

		return new int[] { minTime, cnt };
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] result = bfs(n, k);

		int minTime = result[0];
		int cnt = result[1];

		System.out.println(minTime - 1);
		System.out.println(cnt);
	}
}
