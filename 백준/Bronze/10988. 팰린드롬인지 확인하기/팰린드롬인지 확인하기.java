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
		String reverseStr = new StringBuilder(str).reverse().toString();

		if (str.equals(reverseStr)) {
			sb.append(1);
		} else {
			sb.append(0);
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
