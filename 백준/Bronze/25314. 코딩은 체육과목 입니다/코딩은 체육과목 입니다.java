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

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n / 4; i++) {
			sb.append("long ");
		}
		
		if (n % 4 != 0) {
			sb.append("long ");
		}
		
		sb.append("int");

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
