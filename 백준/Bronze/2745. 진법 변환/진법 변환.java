import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		String n = st.nextToken();
		int b = Integer.parseInt(st.nextToken());

		int decimal = 0;

		for (int i = 0; i < n.length(); i++) {
			char alpha = n.charAt(i);
			int num = 0;
			if (alpha >= 'A' && alpha <= 'Z') {
				num = alpha - 'A' + 10;
			} else {
				num = alpha - '0';
			}
			decimal += num * Math.pow(b, n.length() - 1 - i);
		}

		sb.append(decimal);

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
