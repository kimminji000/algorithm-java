import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		long n = Long.parseLong(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		while (n > 0) {
			char alpha = n % b > 9 ? (char) ('A' + n % b - 10) : (char) ('0' + n % b);
			sb.append(alpha);

			n = n / b;
		}

		sb.reverse();

		System.out.println(sb.toString());
	}
}
