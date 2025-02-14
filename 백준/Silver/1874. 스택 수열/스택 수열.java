import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stk = new Stack<Integer>();
		stk.push(0);

		int cnt = 1;
        StringBuilder str = new StringBuilder();
		Boolean flag = true;

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			if (stk.peek() > num) {
				flag = false;
				break;
			}
			if (stk.peek() < num) {
				while (stk.peek() != num) {
					stk.push(cnt);
					str.append("+\n");
					cnt++;
				}
			}
			stk.pop();
			str.append("-\n");
		}
		
		if (flag == true) {
			System.out.println(str);
		} else {
			System.out.println("NO");
		}
	}
}
