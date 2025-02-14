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

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] lineSum = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				// lineSum[i][j] = lineSum[i][j - 1] + Integer.parseInt(st.nextToken());
				lineSum[i][j] = lineSum[i][j - 1] + lineSum[i - 1][j] - lineSum[i - 1][j - 1]
						+ Integer.parseInt(st.nextToken());
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			int sum = 0;
//			for (int j = x1; j <= x2; j++) {
//				sum += lineSum[j][y2] - lineSum[j][y1 - 1];
//			}
			sum = lineSum[x2][y2] - lineSum[x1 - 1][y2] - lineSum[x2][y1 - 1] + lineSum[x1 - 1][y1 - 1];

			sb.append(sum).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
