import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Deque<Integer> queue = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			String str = st.nextToken();

			switch (str) {
			case "push":
				Integer x = Integer.parseInt(st.nextToken());
				queue.offer(x);
				break;
			case "pop":
				if (queue.isEmpty()) {
					System.out.println("-1");
				} else {
					System.out.println(queue.poll());
				}
				break;
			case "size":
				System.out.println(queue.size());
				break;
			case "empty":
				if (queue.isEmpty()) {
					System.out.println("1");
				} else {
					System.out.println("0");
				}
				break;
			case "front":
				if (queue.isEmpty()) {
					System.out.println("-1");
				} else {
					System.out.println(queue.peekFirst());
				}
				break;
			case "back":
				if (queue.isEmpty()) {
					System.out.println("-1");
				} else {
					System.out.println(queue.peekLast());
				}
				break;
			}
		}
	}
}
