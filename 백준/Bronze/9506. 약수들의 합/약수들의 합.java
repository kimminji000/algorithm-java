import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		while (n != -1) {
			StringBuilder sb = new StringBuilder();

			int sum = 0;

			sb.append(n).append(" = ");

			for (int i = 1; i <= n / 2; i++) {
				if (n % i == 0) {
					sum += i;
					sb.append(i).append(" + ");
				}
			}

			if (sum == n) {
				System.out.println(sb.substring(0, sb.length() - 2).toString());
			} else {
				System.out.println(n + " is NOT perfect.");
			}

			n = Integer.parseInt(br.readLine());
		}
	}
}
