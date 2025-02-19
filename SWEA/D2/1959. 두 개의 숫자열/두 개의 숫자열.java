import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int i = 1; i <= t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int[] ai = new int[n];
			for (int j = 0; j < n; j++) {
				ai[j] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			int[] bj = new int[m];
			for (int j = 0; j < m; j++) {
				bj[j] = Integer.parseInt(st.nextToken());
			}

			int sum = 0, nowSum = 0;
			if (n < m) {
				for (int j = 0; j < n; j++) {
					sum += ai[j] * bj[j];
				}

				for (int j = 1; j < m - n + 1; j++) {
					nowSum = 0;
					for (int k = 0; k < n; k++) {
						nowSum += ai[k] * bj[k + j];
					}
					sum = Math.max(sum, nowSum);
				}
			} else if (n > m) {
				for (int j = 0; j < m; j++) {
					sum += ai[j] * bj[j];
				}

				for (int j = 1; j < n - m + 1; j++) {
					nowSum = 0;
					for (int k = 0; k < m; k++) {
						nowSum += ai[k + j] * bj[k];
					}
					sum = Math.max(sum, nowSum);
				}
			} else {
				for (int j = 0; j < n; j++) {
					sum += ai[j] * bj[j];
				}
			}
			sb.append("#").append(i).append(" ").append(sum).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
