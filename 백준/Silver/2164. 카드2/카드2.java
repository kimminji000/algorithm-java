import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Deque<Integer> queue = new ArrayDeque<>();

		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}

		int cnt = 0;
		while (queue.size() != 1) {
			cnt++;
			if (cnt % 2 == 1) {
				queue.poll();
			} else {
				queue.offer(queue.poll());
			}
		}

		System.out.println(queue.peek());
	}
}
