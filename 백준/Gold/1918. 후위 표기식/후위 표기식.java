import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();

		ArrayDeque<Character> stack = new ArrayDeque<>();

		for (int i = 0; i < str.length(); i++) {
			char now = str.charAt(i);

			if (now >= 'A' && now <= 'Z') {
				sb.append(now);
			} else if (now == '(') {
				stack.push(now);
			} else if (now == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
			} else {
				while (!stack.isEmpty()
						&& !((now == '*' || now == '/') && (stack.peek() == '+' || stack.peek() == '-'))) {
					if (stack.peek() == '(')
						break;
					sb.append(stack.pop());
				}
				stack.push(now);
			}
		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		System.out.println(sb.toString());
	}
}
