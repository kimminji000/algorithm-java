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

		int n = Integer.parseInt(br.readLine());

		a += (b + n) / 60;
		b = (b + n) % 60;

		if (a >= 24) {
			a %= 24;
		}

		sb.append(a).append(" ").append(b).append("\n");

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
