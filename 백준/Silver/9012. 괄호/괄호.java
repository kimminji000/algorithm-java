import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<Character>();
			
			int j;
			for (j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '(') {
					stack.push('(');
				} else {
					if (stack.empty()) {
						break;
					}
					stack.pop();
				}
			}

			if (j == str.length() && stack.empty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
