import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Deque<Integer> queue = new ArrayDeque<>();

		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}

		int cnt = 0;
		while (!queue.isEmpty()) {
			cnt++;

			if (cnt % k == 0) {
				sb.append(queue.poll()).append(", ");
			} else {
				queue.offer(queue.poll());
			}
		}

		System.out.print("<");
		sb.delete(sb.length() - 2, sb.length());
		System.out.print(sb.toString());
		System.out.println(">");
	}
}
