import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Solution {
	public static boolean popCheck(ArrayDeque<Integer> stack, int x) {
		boolean flag = true;

		if (stack.isEmpty())
			flag = false;
		else {
			if (stack.peek() == x)
				stack.pop();
			else
				flag = false;
		}

		return flag;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			int length = Integer.parseInt(br.readLine());
			String str = br.readLine();

			if (length % 2 == 1) {
				sb.append("#").append(t).append(" ").append("0").append("\n");
				continue;
			}

			ArrayDeque<Integer> stack = new ArrayDeque<>();
			boolean flag = true;

			for (int i = 0; i < length; i++) {
				if (str.charAt(i) == '(')
					stack.push(0);
				else if (str.charAt(i) == ')') {
					flag = popCheck(stack, 0);
					if (!flag)
						break;
				} else if (str.charAt(i) == '[')
					stack.push(1);
				else if (str.charAt(i) == ']') {
					flag = popCheck(stack, 1);
					if (!flag)
						break;
				} else if (str.charAt(i) == '{')
					stack.push(2);
				else if (str.charAt(i) == '}') {
					flag = popCheck(stack, 2);
					if (!flag)
						break;
				} else if (str.charAt(i) == '<')
					stack.push(3);
				else if (str.charAt(i) == '>') {
					flag = popCheck(stack, 3);
					if (!flag)
						break;
				}
			}

			if (!stack.isEmpty())
				flag = false;

			if (flag)
				sb.append("#").append(t).append(" ").append("1").append("\n");
			else
				sb.append("#").append(t).append(" ").append("0").append("\n");

		}

		System.out.println(sb.toString());
		br.close();
	}
}
