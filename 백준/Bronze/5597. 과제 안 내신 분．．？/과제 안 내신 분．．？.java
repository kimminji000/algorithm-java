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

		int[] student = new int[31];

		for (int i = 0; i < 28; i++) {
			student[Integer.parseInt(br.readLine())] = 1;
		}

		for (int i = 1; i <= 30; i++) {
			if (student[i] == 0) {
				sb.append(i).append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
