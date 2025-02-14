import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class MyDeque {
		int front = 10000;
		int rear = 10000;
		int[] arr = new int[20000];

		void push_front(int x) {
			arr[--front] = x;
		}

		void push_back(int x) {
			arr[rear++] = x;
		}

		int pop_front() {
			if (rear == front)
				return -1;
			else
				return arr[front++];
		}

		int pop_back() {
			if (rear == front)
				return -1;
			else
				return arr[--rear];
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

		MyDeque myDeque = new MyDeque();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String str = st.nextToken();

			if (str.equals("push_front"))
				myDeque.push_front(Integer.parseInt(st.nextToken()));
			else if (str.equals("push_back"))
				myDeque.push_back(Integer.parseInt(st.nextToken()));
			else if (str.equals("pop_front"))
				System.out.println(myDeque.pop_front());
			else if (str.equals("pop_back"))
				System.out.println(myDeque.pop_back());
			else if (str.equals("size"))
				System.out.println(myDeque.size());
			else if (str.equals("empty"))
				System.out.println(myDeque.empty());
			else if (str.equals("front"))
				System.out.println(myDeque.front());
			else if (str.equals("back"))
				System.out.println(myDeque.back());
		}
	}
}
