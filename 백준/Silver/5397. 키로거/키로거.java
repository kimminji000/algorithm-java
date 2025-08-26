import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;

		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			sb = new StringBuilder();

			String str = br.readLine();

			Deque<Character> left = new ArrayDeque<>();
			Deque<Character> right = new ArrayDeque<>();

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);

				switch (c) {
				case '<':
					if (!left.isEmpty()) {
						right.push(left.pop());
					}
					break;
				case '>':
					if (!right.isEmpty()) {
						left.push(right.pop());
					}
					break;
				case '-':
					if (!left.isEmpty()) {
						left.pop();
					}
					break;
				default:
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
}
