import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		for (int i = 0; queue.size() != 1; i++) {
			if (i % 2 == 0) {
				queue.poll();
			} else {
				queue.add(queue.poll());
			}
		}

		System.out.println(queue.peek());
	}
}
