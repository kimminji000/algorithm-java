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

		int n = Integer.parseInt(br.readLine());

		int roomNum = 1, i;

		for (i = 1; n > roomNum; i++) {
			roomNum += 6 * i;
		}

		sb.append(i);

		bw.append(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
