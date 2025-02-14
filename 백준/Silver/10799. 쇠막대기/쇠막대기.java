import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		Stack<Character> stack = new Stack<Character>();

		int i = 0, count = 0;
		while (i < str.length()) {
			if (str.charAt(i) == '(' && str.charAt(i + 1) == ')') {
				count += stack.size();
				i += 2;
			} else if (str.charAt(i) == '(') {
				stack.push('(');
				i++;
			} else if (str.charAt(i) == ')') {
				stack.pop();
				count++;
				i++;
			}
		}
		System.out.println(count);
	}
}
