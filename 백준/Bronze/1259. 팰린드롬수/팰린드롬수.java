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

		String num = br.readLine();

		while (!num.equals("0")) {
			boolean flag = true;
			for (int i = 0; i < num.length() - i - 1; i++) {
				if (num.charAt(i) != num.charAt(num.length() - i - 1)) {
					flag = false;
					break;
				}
			}

			if (flag) {
				sb.append("yes").append("\n");
			} else {
				sb.append("no").append("\n");
			}

			num = br.readLine();
		}

		bw.append(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
