import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		ArrayDeque<Character> stack = new ArrayDeque<>();

		int cnt = 0;

		for (int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);

			switch (c) {
			case '(':
				stack.push(c);
				break;

			case ')':
				stack.pop();
				if (str.charAt(i - 1) == '(') {
					cnt += stack.size();
				} else {
					cnt++;
				}
				break;
			}
		}

		System.out.println(cnt);
	}
}
