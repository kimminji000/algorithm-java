import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;

		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			String p = br.readLine();

			int n = Integer.parseInt(br.readLine());

			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str.substring(1, str.length() - 1), ",");

			Deque<Integer> deque = new ArrayDeque<Integer>();
			for (int i = 0; i < n; i++) {
				deque.offer(Integer.parseInt(st.nextToken()));
			}

			boolean reverse = false;
			boolean flag = true;

			for (int i = 0; i < p.length(); i++) {
				if (p.charAt(i) == 'R') {
					reverse = !reverse;
				} else {
					if (deque.isEmpty()) {
						flag = false;
						break;
					}

					if (reverse) {
						deque.pollLast();
					} else {
						deque.pollFirst();
					}
				}
			}

			if (flag) {
				sb = new StringBuilder();

				sb.append("[");
				while (!deque.isEmpty()) {
					sb.append(reverse ? deque.pollLast() : deque.pollFirst()).append(",");
				}
				if (sb.length() != 1) {
					sb.deleteCharAt(sb.length() - 1);
				}
				sb.append("]");

				System.out.println(sb.toString());
			} else {
				System.out.println("error");
			}
		}
	}
}
