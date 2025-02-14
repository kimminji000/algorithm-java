import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] prime = new int[n + 1];

		for (int i = 2; i <= n; i++) {
			prime[i] = i;
		}

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (prime[i] == 0) {
				continue;
			}

			for (int j = i + 1; j <= n; j++) {
				if (j % i == 0 && prime[i] != 0) {
					prime[j] = 0;
				}
			}

//			for (int j = i + i; j <= n; j += i) {
//				prime[j] = 0;
//			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = m; i <= n; i++) {
			if (prime[i] != 0) {
				sb.append(i).append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
