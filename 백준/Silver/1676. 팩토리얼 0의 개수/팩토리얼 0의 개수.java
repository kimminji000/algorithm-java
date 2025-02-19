import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int cnt2 = 0, cnt5 = 0;
		for (int i = 1; i <= n; i++) {
			int num = i;
			while (num % 2 == 0) {
				num /= 2;
				cnt2++;
			}

			while (num % 5 == 0) {
				num /= 5;
				cnt5++;
			}
		}

		sb.append(Math.min(cnt2, cnt5));

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
