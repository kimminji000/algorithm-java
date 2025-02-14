import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int cnt = 0, score = 0;

			String str = br.readLine();

			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == 'O') {
					cnt++;
					score += cnt;
				} else {
					cnt = 0;
				}
			}

			sb.append(score).append("\n");
		}

		bw.append(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
