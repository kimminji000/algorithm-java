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

		int cnt = 0;
		String num = null;
		for (int i = 666; cnt < n; i++) {
			num = Integer.toString(i);

			if (num.contains("666")) {
				cnt++;
			}
		}

		sb.append(num);

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
