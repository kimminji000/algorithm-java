import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] board;
	static Map<Integer, Integer> labbers;
	static Map<Integer, Integer> snakes;

	static void bfs() {
		board[1] = 0;

		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(1);

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i = 1; i <= 6; i++) {
				if (now + i <= 100 && board[now] != -1) {
					if (board[now] + 1 < board[now + i]) {
						board[now + i] = board[now] + 1;
						queue.offer(now + i);

						if (labbers.containsKey(now + i)) {
							board[labbers.get(now + i)] = Math.min(board[labbers.get(now + i)], board[now + i]);
							board[now + i] = -1;
							queue.offer(labbers.get(now + i));
						}

						if (snakes.containsKey(now + i)) {
							board[snakes.get(now + i)] = Math.min(board[snakes.get(now + i)], board[now + i]);
							board[now + i] = -1;
							queue.offer(snakes.get(now + i));
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		board = new int[101];
		Arrays.fill(board, Integer.MAX_VALUE);

		labbers = new HashMap<>();
		snakes = new HashMap<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			labbers.put(x, y);
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			snakes.put(u, v);
		}

		bfs();

		System.out.println(board[100]);
	}
}
