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

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int h = Integer.parseInt(st.nextToken());
			Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			int f = n % h == 0 ? h : n % h;

			sb.append(f * 100 + ((n - 1) / h) + 1).append("\n");
		}

		bw.append(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
