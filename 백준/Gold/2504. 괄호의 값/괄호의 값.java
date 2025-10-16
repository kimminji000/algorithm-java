import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		ArrayDeque<Character> stack = new ArrayDeque<>();

		int sum = 0;
		int sign = 1;
		boolean flag = true;

		for (int i = 0; i < str.length(); i++) {
			switch (str.charAt(i)) {
			case '(':
				stack.push('(');
				sign *= 2;
				break;
			case '[':
				stack.push('[');
				sign *= 3;
				break;
			case ')':
				if (stack.isEmpty() || stack.peek() != '(') {
					flag = false;
					break;
				}
				if (str.charAt(i - 1) == '(') {
					sum += sign;
				}
				stack.pop();
				sign /= 2;
				break;
			case ']':
				if (stack.isEmpty() || stack.peek() != '[') {
					flag = false;
					break;
				}
				if (str.charAt(i - 1) == '[') {
					sum += sign;
				}
				stack.pop();
				sign /= 3;
				break;
			}
		}

		if (!stack.isEmpty() || !flag) {
			System.out.println(0);
		} else {
			System.out.println(sum);
		}
	}
}
