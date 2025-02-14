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

		String str = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			if ('a' <= (int) str.charAt(i) && (int) str.charAt(i) <= 'z') {
				sb.append((char) (str.charAt(i) - 'a' + 'A'));
			} else {
				sb.append((char) (str.charAt(i) - 'A' + 'a'));
			}
		}

		bw.append(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
