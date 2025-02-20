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

		int t = Integer.parseInt(br.readLine());
		int s = Integer.parseInt(br.readLine());
		String str = br.readLine();

		int cnt = 0;

		for (int i = 0; i < s - 2 * t; i++) {
			for (int j = 0; j < 2 * t + 1; j++) {
				char now = str.charAt(i + j);

				if (!((j % 2 == 0 && now == 'I') || (j % 2 == 1 && now == 'O'))) {
					break;
				}

				if (j == 2 * t) {
					cnt++;
				}
			}
		}

		sb.append(cnt);

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
