import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 10; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] building = new int[n];

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				building[j] = Integer.parseInt(st.nextToken());
			}

			int cnt = 0;
			for (int j = 2; j < n - 2; j++) {
				if (building[j] > building[j - 2] && building[j] > building[j - 1] && building[j] > building[j + 1]
						&& building[j] > building[j + 2]) {
					int max = Arrays
							.stream(new int[] { building[j - 2], building[j - 1], building[j + 1], building[j + 2] })
							.max().getAsInt();
					cnt += building[j] - max;
				}
			}

			sb.append("#").append(i + 1).append(" ").append(cnt).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
