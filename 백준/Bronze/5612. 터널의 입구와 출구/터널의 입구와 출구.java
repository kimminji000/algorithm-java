import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int max = m;
		boolean flag = false;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			m += a;
			m -= b;
			max = Math.max(max, m);
			if (m < 0) {
				flag = true;
			}
		}

		System.out.println(flag ? 0 : max);
	}
}
