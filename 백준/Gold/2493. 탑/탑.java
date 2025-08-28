import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[] towers = new int[n + 1];
		int[] receivers = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			towers[i] = Integer.parseInt(st.nextToken());
		}

		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(n);

		for (int i = n - 1; i > 0; i--) {
			while (!stack.isEmpty() && towers[i] >= towers[stack.peek()]) {
				receivers[stack.pop()] = i;
			}
			stack.push(i);
		}

		for (int i = 1; i <= n; i++) {
			sb.append(receivers[i]).append(" ");
		}

		System.out.println(sb.toString());
	}
}
