import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] num;
	static int[][] sum;

	static void dp() {
		sum[0][0] = num[0][0];

		for (int i = 1; i < n; i++) {
			sum[i][0] = sum[i - 1][0] + num[i][0];
			for (int j = 1; j < i; j++) {
				sum[i][j] = Math.max(sum[i - 1][j - 1], sum[i - 1][j]) + num[i][j];
			}
			sum[i][i] = sum[i - 1][i - 1] + num[i][i];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		num = new int[n][n];
		sum = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j <= i; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp();

		int maxSum = sum[n - 1][0];
		for (int i = 1; i < n; i++) {
			maxSum = Math.max(sum[n - 1][i], maxSum);
		}

		System.out.println(maxSum);
	}
}
