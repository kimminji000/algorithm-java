import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static class MyDeque {
		int front = 10000;
		int rear = 10000;
		int[] arr = new int[20001];

		void push_front(int x) {
			arr[--front] = x;
		}

		void push_back(int x) {
			arr[rear++] = x;
		}

		int pop_front() {
			if (empty() == 1) {
				return -1;
			}
			return arr[front++];
		}

		int pop_back() {
			if (empty() == 1) {
				return -1;
			}
			return arr[--rear];
		}

		int size() {
			return rear - front;
		}

		int empty() {
			if (front == rear) {
				return 1;
			}
			return 0;
		}

		int front() {
			if (empty() == 1) {
				return -1;
			}
			return arr[front];
		}

		int back() {
			if (empty() == 1) {
				return -1;
			}
			return arr[rear - 1];
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		MyDeque deque = new MyDeque();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			String str = st.nextToken();

			switch (str) {
			case "push_front":
				int x = Integer.parseInt(st.nextToken());
				deque.push_front(x);
				break;
			case "push_back":
				int y = Integer.parseInt(st.nextToken());
				deque.push_back(y);
				break;
			case "pop_front":
				sb.append(deque.pop_front()).append("\n");
				break;
			case "pop_back":
				sb.append(deque.pop_back()).append("\n");
				break;
			case "size":
				sb.append(deque.size()).append("\n");
				break;
			case "empty":
				sb.append(deque.empty()).append("\n");
				break;
			case "front":
				sb.append(deque.front()).append("\n");
				break;
			case "back":
				sb.append(deque.back()).append("\n");
				break;
			}
		}

		System.out.println(sb.toString());
	}
}
