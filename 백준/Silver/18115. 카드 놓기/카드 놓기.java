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
		int[] command = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			command[i] = Integer.parseInt(st.nextToken());
		}

		Deque<Integer> card = new ArrayDeque<>();
		for (int i = n; i >= 1; i--) {
			switch (command[i]) {
			case 1:
				card.addFirst(n - i + 1);
				break;
			case 2:
				int top = card.pollFirst();
				card.addFirst(n - i + 1);
				card.addFirst(top);
				break;
			case 3:
				card.addLast(n - i + 1);
				break;
			}
		}

		for (int i = 1; i <= n; i++) {
			sb.append(card.pollFirst()).append(" ");
		}

		System.out.println(sb.toString());
	}
}
