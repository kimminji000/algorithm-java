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
			for (int j = 1; j < i; j++) {
				sb.append(" ");
			}
			for (int j = 2 * (n - i + 1) - 1; j > 0; j--) {
				sb.append("*");
			}
			sb.append("\n");
		}

//		for (int i = 0; i < n; i++) {
//			sb.append(" ".repeat(i)).append("*".repeat(2 * (n - i) - 1)).append("\n");
//		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
