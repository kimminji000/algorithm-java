import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int[] num = new int[42];

		for (int i = 0; i < 10; i++) {
			num[Integer.parseInt(br.readLine()) % 42]++;
		}

		int cnt = 0;

		for (int i = 0; i < 42; i++) {
			if (num[i] != 0) {
				cnt++;
			}
		}

		sb.append(cnt);

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
