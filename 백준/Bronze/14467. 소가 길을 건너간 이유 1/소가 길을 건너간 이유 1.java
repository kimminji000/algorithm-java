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

		int n = Integer.parseInt(br.readLine());

		int[] cow = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int num = Integer.parseInt(st.nextToken());
			int position = Integer.parseInt(st.nextToken());

			if (cow[num] == -1) {
				cow[num] = position;
			} else {
				if (cow[num] != position) {
					cow[num] = position;
					cnt++;
				}
			}
		}

		sb.append(Integer.toString(cnt));

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
