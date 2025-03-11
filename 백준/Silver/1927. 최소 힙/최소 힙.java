import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num > 0) {
				pq.offer(num);
			} else {
				sb.append(pq.isEmpty() ? 0 : pq.poll()).append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}
