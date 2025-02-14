import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			String str = br.readLine();

			int[] alpha = new int[26];

			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) >= 'a' && str.charAt(j) <= 'z') {
					alpha[str.charAt(j) - 'a']++;
				}
			}

			int maxIndex = 0;
			boolean flag = true;
			for (int j = 1; j < 26; j++) {
				if (alpha[j] > alpha[maxIndex]) {
					flag = true;
					maxIndex = j;
				} else if (alpha[j] == alpha[maxIndex]) {
					flag = false;
				}
			}

			if (flag) {
				sb.append((char) ('a' + maxIndex)).append("\n");
			} else {
				sb.append("?\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
