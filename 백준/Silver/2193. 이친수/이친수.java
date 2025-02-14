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

		long[][] num = new long[n + 1][2];

		num[1][0] = 0;
		num[1][1] = 1;

		for (int i = 2; i <= n; i++) {
			num[i][0] = num[i - 1][0] + num[i - 1][1];
			num[i][1] = num[i - 1][0];
		}

		sb.append(num[n][0] + num[n][1]);

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
