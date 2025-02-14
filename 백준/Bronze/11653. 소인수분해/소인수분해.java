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

		int a = Integer.parseInt(br.readLine());
		int i = 2;
		while (a > 1) {
			while (a % i == 0) {
				sb.append(i).append("\n");
				a /= i;
			}
			i++;
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
