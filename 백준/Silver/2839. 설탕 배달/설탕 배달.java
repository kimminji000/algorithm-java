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

		for (int i = n / 5; i >= 0; i--) {
			for (int j = (n - 5 * i) / 3; j >= 0; j--) {
				if ((n - 5 * i) % 3 == 0) {
					sb.append(i + j);

					bw.write(sb.toString());
					bw.flush();
					br.close();
					bw.close();

					return;
				}
			}
		}

		sb.append(-1);

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
