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

		int x = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());

		int money = 0;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			money += a * b;
		}

		if (x == money) {
			sb.append("Yes");
		} else {
			sb.append("No");
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
