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

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		if (a > b) {
			int temp = a;
			a = b;
			b = temp;
		}

		int factor = 0, multiple = 0;

		for (int i = a; i > 0; i--) {
			if (a % i == 0 && b % i == 0) {
				factor = i;
				break;
			}
		}

		int i = b;
		while (true) {
			if (i % a == 0) {
				multiple = i;
				break;
			}
			i += b;
		}

		sb.append(factor).append("\n").append(multiple);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
