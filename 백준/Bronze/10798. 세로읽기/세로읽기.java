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

		String[] str = new String[5];
		int maxLength = 0;

		for (int i = 0; i < 5; i++) {
			str[i] = br.readLine();

			if (str[i].length() > maxLength) {
				maxLength = str[i].length();
			}
		}

		for (int i = 0; i < maxLength; i++) {
			for (int j = 0; j < 5; j++) {
				if (str[j].length() < i + 1) {
					continue;
				}
				sb.append(str[j].charAt(i));
			}
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
