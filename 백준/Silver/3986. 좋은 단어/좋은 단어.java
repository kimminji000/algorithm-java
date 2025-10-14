import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int cnt = 0;

		for (int i = 0; i < n; i++) {
			String str = br.readLine();

			ArrayDeque<Character> stack = new ArrayDeque<>();

			for (int j = 0; j < str.length(); j++) {
				Character c = str.charAt(j);

				if (stack.isEmpty() || stack.peek() != c) {
					stack.push(c);
				} else {
					stack.pop();
				}
			}

			if (stack.isEmpty()) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
