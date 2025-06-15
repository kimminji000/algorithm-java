import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int c = b - a;

		for (int i = 9; i > 1; i--) {
			if (b % i == 0 && c % i == 0) {
				b /= i;
				c /= i;
			}
		}

		System.out.printf("%d %d", c, b);
	}
}
