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
		int c = Integer.parseInt(st.nextToken());

		while (a > 0 && b > 0 && c > 0) {
			int max = Math.max(a, b);
			max = Math.max(max, c);

			if (max == a) {
				if (Math.pow(b, 2) + Math.pow(c, 2) == Math.pow(a, 2)) {
					sb.append("right").append("\n");
				} else {
					sb.append("wrong").append("\n");
				}
			} else if (max == b) {
				if (Math.pow(a, 2) + Math.pow(c, 2) == Math.pow(b, 2)) {
					sb.append("right").append("\n");
				} else {
					sb.append("wrong").append("\n");
				}
			} else {
				if (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2)) {
					sb.append("right").append("\n");
				} else {
					sb.append("wrong").append("\n");
				}
			}

			st = new StringTokenizer(br.readLine());

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
		}

		bw.append(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
