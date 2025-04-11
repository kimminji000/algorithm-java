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

		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			String p = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str.substring(1, str.length() - 1), ",");

			Deque<Integer> num = new ArrayDeque<>();
			for (int i = 0; i < n; i++) {
				num.offer(Integer.parseInt(st.nextToken()));
			}

			boolean flag = true;
			boolean reverse = false;

			for (int i = 0; i < p.length(); i++) {
				switch (p.charAt(i)) {
				case 'R':
					reverse = !reverse;
					break;

				case 'D':
					if (num.size() == 0) {
						flag = false;
					} else if (!reverse) {
						num.pollFirst();
					} else {
						num.pollLast();
					}
					break;
				}
			}

			if (flag) {
				if (num.isEmpty()) {
					sb.append("[]").append("\n");
				} else {
					sb.append("[");

					if (!reverse) {
						while (!num.isEmpty()) {
							sb.append(num.pollFirst()).append(",");
						}
					} else {
						while (!num.isEmpty()) {
							sb.append(num.pollLast()).append(",");
						}
					}

					sb.deleteCharAt(sb.length() - 1);

					sb.append("]").append("\n");
				}
			} else {
				sb.append("error").append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}
