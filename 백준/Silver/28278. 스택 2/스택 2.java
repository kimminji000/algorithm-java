import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class MyStack {
	int[] stack = new int[1000000];
	int top = 0;

	public void push(int x) {
		stack[top++] = x;
	}

	public int pop() {
		if (empty() == 1) {
			return -1;
		}
		return stack[--top];
	}

	public int size() {
		return top;
	}

	public int empty() {
		if (top == 0) {
			return 1;
		}
		return 0;
	}

	public int top() {
		if (empty() == 1) {
			return -1;
		}
		return stack[top - 1];
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		MyStack myStack = new MyStack();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String str = st.nextToken();

			switch (str) {
			case "1":
				int num = Integer.parseInt(st.nextToken());
				myStack.push(num);
				break;
			case "2":
				sb.append(myStack.pop()).append("\n");
				break;
			case "3":
				sb.append(myStack.size()).append("\n");
				break;
			case "4":
				sb.append(myStack.empty()).append("\n");
				break;
			case "5":
				sb.append(myStack.top()).append("\n");
				break;
			}
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
