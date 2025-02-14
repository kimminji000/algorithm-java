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

		String str = br.readLine();
		str = str.toUpperCase();

		int[] alpha = new int[26];

		for (int i = 0; i < str.length(); i++) {
			alpha[str.charAt(i) - 'A']++;
		}

		int maxIndex = 0;
		for (int i = 1; i < 26; i++) {
			if (alpha[i] > alpha[maxIndex]) {
				maxIndex = i;
			}
		}

		Arrays.sort(alpha);

		if (alpha[25] == alpha[24]) {
			sb.append("?");
		} else {
			sb.append((char) (maxIndex + 'A'));
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
