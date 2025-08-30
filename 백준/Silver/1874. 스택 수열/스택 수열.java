import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		Deque<Integer> stack = new ArrayDeque<>();
		int index = 1;

		boolean flag = true;

		for (int i = 0; i < n; i++) {
			int k = Integer.parseInt(br.readLine());

			while (index <= k) {
				stack.push(index++);
				sb.append("+").append("\n");
			}

			if (!stack.isEmpty() && stack.peek() == k) {
				stack.pop();
				sb.append("-").append("\n");
			} else {
				flag = false;
				break;
			}
		}

		if (flag) {
			System.out.println(sb.toString());
		} else {
			System.out.println("NO");
		}
	}
}
