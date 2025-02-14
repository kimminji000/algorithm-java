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

		int[][] color = new int[n + 1][3]; // 각집을 칠하는 비용

		long[][] price = new long[n + 1][3]; // 지금까지 칠한 비용

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		price[1][0] = color[1][0]; // 빨강
		price[1][1] = color[1][1]; // 초록
		price[1][2] = color[1][2]; // 파랑

		for (int i = 2; i <= n; i++) {
			// 지금 빨강이면 이전 초,파
			price[i][0] = Math.min(price[i - 1][1], price[i - 1][2]) + color[i][0];
			// 지금 초록이면 이전 빨,파
			price[i][1] = Math.min(price[i - 1][0], price[i - 1][2]) + color[i][1];
			// 지금 파랑이면 이전 빨,초
			price[i][2] = Math.min(price[i - 1][0], price[i - 1][1]) + color[i][2];
		}

		long minPrice = Math.min(price[n][0], price[n][1]);
		minPrice = Math.min(minPrice, price[n][2]);
		sb.append(minPrice);

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
