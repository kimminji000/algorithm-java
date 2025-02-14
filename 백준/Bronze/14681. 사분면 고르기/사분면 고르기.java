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

		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());

		if (x > 0 && y > 0) {
			sb.append(1);
		} else if (x < 0 && y > 0) {
			sb.append(2);
		} else if (x < 0 && y < 0) {
			sb.append(3);
		} else {
			sb.append(4);
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
