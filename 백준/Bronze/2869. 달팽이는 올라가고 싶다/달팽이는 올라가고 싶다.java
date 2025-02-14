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
		int v = Integer.parseInt(st.nextToken());

		int day = 0;

		if (a >= v) {
			day = 1;
		} else {
			v -= a;
			day = (v % (a - b) == 0 ? v / (a - b) : v / (a - b) + 1) + 1;
		}

		sb.append(day);

		bw.append(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
