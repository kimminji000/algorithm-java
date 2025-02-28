import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int c = Integer.parseInt(br.readLine());

			sb.append((int) c / 25).append(" ");
			c %= 25;

			sb.append(c / 10).append(" ");
			c %= 10;

			sb.append(c / 5).append(" ");
			c %= 5;

			sb.append(c / 1).append("\n");
		}

		System.out.println(sb.toString());

		br.close();
	}
}
