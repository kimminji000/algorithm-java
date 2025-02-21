import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= 10; i++) {
			int t = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());

			ArrayDeque<Integer> queue = new ArrayDeque<>();

			for (int j = 0; j < 8; j++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}

			int number = -1, cnt = 1;

			while (true) {
				number = queue.poll();

				if (cnt % 5 == 1) {
					if (number - 1 <= 0) {
						queue.offer(0);
						break;
					} else {
						queue.offer(number - 1);
					}
				} else if (cnt % 5 == 2) {
					if (number - 2 <= 0) {
						queue.offer(0);
						break;
					} else {
						queue.offer(number - 2);
					}
				} else if (cnt % 5 == 3) {
					if (number - 3 <= 0) {
						queue.offer(0);
						break;
					} else {
						queue.offer(number - 3);
					}
				} else if (cnt % 5 == 4) {
					if (number - 4 <= 0) {
						queue.offer(0);
						break;
					} else {
						queue.offer(number - 4);
					}
				} else {
					if (number - 5 <= 0) {
						queue.offer(0);
						break;
					} else {
						queue.offer(number - 5);
					}
				}
				cnt++;
			}

			sb.append("#").append(t).append(" ");

			for (int j = 0; j < 8; j++) {
				sb.append(queue.poll()).append(" ");
			}

			sb.append("\n");
		}

		System.out.println(sb.toString());

		br.close();
	}
}
