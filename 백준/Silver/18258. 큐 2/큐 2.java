import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class MyQueue {
		int front = 0;
		int rear = 0;
		int[] arr = new int[2000000];

		void push(int x) {
			arr[rear++] = x;
		}

		int pop() {
			if (empty() == 1) {
				return -1;
			}
			return arr[front++];
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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		MyQueue queue = new MyQueue();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			String str = st.nextToken();

			switch (str) {
			case "push":
				int x = Integer.parseInt(st.nextToken());
				queue.push(x);
				break;
			case "pop":
				sb.append(queue.pop()).append("\n");
				break;
			case "size":
				sb.append(queue.size()).append("\n");
				break;
			case "empty":
				sb.append(queue.empty()).append("\n");
				break;
			case "front":
				sb.append(queue.front()).append("\n");
				break;
			case "back":
				sb.append(queue.back()).append("\n");
				break;
			}
		}

		System.out.println(sb.toString());
	}
}
