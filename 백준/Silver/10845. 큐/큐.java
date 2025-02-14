import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class MyQueue {
		int front = 0;
		int rear = 0;
		int[] arr = new int[10000];

		void push(int x) {
			arr[rear++] = x;
		}

		int pop() {
			if (rear == front)
				return -1;
			else
				return arr[front++];
		}

		int size() {
			return rear - front;
		}

		int empty() {
			if (rear == front)
				return 1;
			else
				return 0;
		}

		int front() {
			if (rear == front)
				return -1;
			else
				return arr[front];
		}

		int back() {
			if (rear == front)
				return -1;
			else
				return arr[rear - 1];
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		MyQueue myQueue = new MyQueue();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();

			if (str.equals("push"))
				myQueue.push(Integer.parseInt(st.nextToken()));
			else if (str.equals("pop"))
				System.out.println(myQueue.pop());
			else if (str.equals("size"))
				System.out.println(myQueue.size());
			else if (str.equals("empty"))
				System.out.println(myQueue.empty());
			else if (str.equals("front"))
				System.out.println(myQueue.front());
			else if (str.equals("back"))
				System.out.println(myQueue.back());
		}
	}
}
