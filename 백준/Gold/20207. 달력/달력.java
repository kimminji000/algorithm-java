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

		int[] calendar = new int[366];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			for (int j = start; j <= end; j++) {
				calendar[j]++;
			}
		}

		int max = 0, startIndex = 0, cnt = 0;
		for (int i = 1; i <= 365; i++) {
			if (calendar[i] > 0) {
				if (startIndex == 0) {
					startIndex = i;
				}

				max = Math.max(calendar[i], max);
			} else {
				if (startIndex != 0) {
					cnt += (i - startIndex) * max;
					startIndex = 0;
					max = 0;
				}
			}
		}
		
		if (startIndex != 0) {
			cnt += (366 - startIndex) * max;
		}
		
		sb.append(Integer.toString(cnt));

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
