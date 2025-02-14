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

		int time = 0;

		for (int i = 0; i < str.length(); i++) {
			char alpha = str.charAt(i);
			if (alpha >= 'A' && alpha <= 'C') {
				time += 3;
			} else if (alpha >= 'D' && alpha <= 'F') {
				time += 4;
			} else if (alpha >= 'G' && alpha <= 'I') {
				time += 5;
			} else if (alpha >= 'J' && alpha <= 'L') {
				time += 6;
			} else if (alpha >= 'M' && alpha <= 'O') {
				time += 7;
			} else if (alpha >= 'P' && alpha <= 'S') {
				time += 8;
			} else if (alpha >= 'T' && alpha <= 'V') {
				time += 9;
			} else if (alpha >= 'W' && alpha <= 'Z') {
				time += 10;
			}
		}

		sb.append(time);

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
