import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int cnt;

	public static void solution(int sum, int n) {
		if (sum == n) {
			cnt++;
			return;
		}

		for (int i = 1; i <= 3; i++) {
			if (sum + i <= n) {
				solution(sum + i, n);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());

			cnt = 0;
			solution(0, n);

			sb.append(cnt).append("\n");
		}

		System.out.println(sb.toString());

		br.close();
	}
}
