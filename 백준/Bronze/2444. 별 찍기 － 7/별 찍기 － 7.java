import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			for (int j = n - i; j > 0; j--) {
				sb.append(" ");
			}
			for (int j = 1; j <= 2 * i - 1; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}

		for (int i = n - 1; i >= 1; i--) {
			for (int j = n - i; j > 0; j--) {
				sb.append(" ");
			}
			for (int j = 1; j <= 2 * i - 1; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}

//		for (int i = 1; i <= n; i++) {
//			sb.append(" ".repeat(n - i)).append("*".repeat(2 * i - 1)).append("\n");
//		}
//
//		for (int i = n - 1; i > 0; i--) {
//			sb.append(" ".repeat(n - i)).append("*".repeat(2 * i - 1)).append("\n");
//		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
