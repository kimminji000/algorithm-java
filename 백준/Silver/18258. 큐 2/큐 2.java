import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class MyQueue {
	int[] queue = new int[2000000];
	int front = 0;
	int back = 0;

	public void push(int x) {
		queue[back++] = x;
	}

	public int pop() {
		if (empty() == 1) {
			return -1;
		}
		return queue[front++];
	}

	public int size() {
		return back - front;
	}

	public int empty() {
		if (front == back) {
			return 1;
		}
		return 0;
	}

	public int front() {
		if (empty() == 1) {
			return -1;
		}
		return queue[front];
	}

	public int back() {
		if (empty() == 1) {
			return -1;
		}
		return queue[back - 1];
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		MyQueue myQueue = new MyQueue();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String str = st.nextToken();

			switch (str) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				myQueue.push(num);
				break;
			case "pop":
				sb.append(myQueue.pop()).append("\n");
				break;
			case "size":
				sb.append(myQueue.size()).append("\n");
				break;
			case "empty":
				sb.append(myQueue.empty()).append("\n");
				break;
			case "front":
				sb.append(myQueue.front()).append("\n");
				break;
			case "back":
				sb.append(myQueue.back()).append("\n");
				break;
			}
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
