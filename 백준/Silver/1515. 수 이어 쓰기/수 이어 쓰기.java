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

		int ans = 1, strIndex = 0;
		while (true) {
			String num = String.valueOf(ans);

			for (int i = 0; i < num.length(); i++) {
				if (str.charAt(strIndex) == num.charAt(i)) {
					strIndex++;
				}
				if (strIndex == str.length()) {
					sb.append(Integer.toString(ans));
					bw.write(sb.toString());
					bw.flush();
					br.close();
					bw.close();
					return;
				}
			}
			ans++;
		}
	}
}
