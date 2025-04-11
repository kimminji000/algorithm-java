import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int cnt;
	static StringBuilder sb;

	private static void hanoi(int from, int to, int none, int num) {
		if (num == 0) {
			return;
		}

		hanoi(from, none, to, num - 1);
		sb.append(from).append(" ").append(to).append("\n");
		cnt++;
		hanoi(none, to, from, num - 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		cnt = 0;

		hanoi(1, 3, 2, n);

		System.out.println(cnt);
		System.out.println(sb.toString());
	}
}
