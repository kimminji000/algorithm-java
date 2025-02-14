import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class MyStack {
		int[] arr = new int[10000];
		int ptr = -1;

		void push(int x) {
			arr[++ptr] = x;
		}

		int pop() {
			if (ptr < 0) {
				System.out.println("-1");
				return -1;
			} else {
				System.out.println(arr[ptr]);
				return arr[ptr--];
			}
		}

		int size() {
			System.out.println(ptr + 1);
			return ptr + 1;
		}

		int empty() {
			if (ptr < 0) {
				System.out.println(1);
				return 1;
			} else {
				System.out.println(0);
				return 0;
			}
		}

		int top() {
			if (ptr < 0) {
				System.out.println(-1);
				return -1;
			} else {
				System.out.println(arr[ptr]);
				return arr[ptr];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		MyStack myStack = new MyStack();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();

			if (str.equals("push")) {
				myStack.push(Integer.parseInt(st.nextToken()));
			} else if (str.equals("pop")) {
				myStack.pop();
			} else if (str.equals("size")) {
				myStack.size();
			} else if (str.equals("empty")) {
				myStack.empty();
			} else if (str.equals("top")) {
				myStack.top();
			}
		}
	}
}
