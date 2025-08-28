import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static class MyStack {
		int top = 0;
		int[] arr = new int[10000];

		void push(int x) {
			arr[top++] = x;
		}

		int pop() {
			if (empty() == 1) {
				return -1;
			}
			return arr[--top];
		}

		int size() {
			return top;
		}

		int empty() {
			if (top == 0) {
				return 1;
			}
			return 0;
		}

		int top() {
			if (empty() == 1) {
				return -1;
			}
			return arr[top - 1];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		MyStack myStack = new MyStack();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			String str = st.nextToken();

			switch (str) {
			case "push":
				int x = Integer.parseInt(st.nextToken());
				myStack.push(x);
				break;
			case "pop":
				sb.append(myStack.pop()).append("\n");
				break;
			case "size":
				sb.append(myStack.size()).append("\n");
				break;
			case "empty":
				sb.append(myStack.empty()).append("\n");
				break;
			case "top":
				sb.append(myStack.top()).append("\n");
				break;
			}
		}

		System.out.println(sb.toString());
	}
}
