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
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();

		int m = Integer.parseInt(br.readLine());

		Deque<Character> left = new ArrayDeque<>();
		Deque<Character> right = new ArrayDeque<>();

		for (int i = 0; i < str.length(); i++) {
			left.push(str.charAt(i));
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			char alpha = st.nextToken().charAt(0);

			switch (alpha) {
			case 'L':
				if (!left.isEmpty()) {
					right.push(left.pop());
				}
				break;
			case 'D':
				if (!right.isEmpty()) {
					left.push(right.pop());
				}
				break;
			case 'B':
				if (!left.isEmpty()) {
					left.pop();
				}
				break;
			case 'P':
				char c = st.nextToken().charAt(0);
				left.push(c);
				break;
			}
		}

		while (!left.isEmpty()) {
			sb.append(left.pop());
		}
		sb.reverse();
		while (!right.isEmpty()) {
			sb.append(right.pop());
		}

		System.out.println(sb.toString());
	}
}
