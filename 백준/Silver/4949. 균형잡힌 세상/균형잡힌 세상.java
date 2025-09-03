import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			String str = br.readLine();

			if (str.equals(".")) {
				break;
			}

			ArrayDeque<Character> stack = new ArrayDeque<>();

			boolean flag = true;

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);

				switch (c) {
				case '(':
				case '[':
					stack.push(c);
					break;
				case ')':
					if (stack.isEmpty() || stack.peek() != '(') {
						flag = false;
						break;
					}
					stack.pop();
					break;
				case ']':
					if (stack.isEmpty() || stack.peek() != '[') {
						flag = false;
						break;
					}
					stack.pop();
					break;
				}
				if (!flag)
					break;
			}

			if (!stack.isEmpty() || !flag) {
				sb.append("no").append("\n");
			} else {
				sb.append("yes").append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}
