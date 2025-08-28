import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	private static class Tower {
		int index;
		int height;

		public Tower(int index, int height) {
			super();
			this.index = index;
			this.height = height;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		Tower[] towers = new Tower[n + 1];
		int[] receivers = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			towers[i] = new Tower(i, Integer.parseInt(st.nextToken()));
		}

		Deque<Tower> stack = new ArrayDeque<>();
		stack.push(towers[n]);

		for (int i = n - 1; i > 0; i--) {
			while (!stack.isEmpty() && towers[i].height >= stack.peek().height) {
				Tower tower = stack.pop();
				receivers[tower.index] = i;
			}
			stack.push(towers[i]);
		}

		for (int i = 1; i <= n; i++) {
			sb.append(receivers[i]).append(" ");
		}

		System.out.println(sb.toString());
	}
}
