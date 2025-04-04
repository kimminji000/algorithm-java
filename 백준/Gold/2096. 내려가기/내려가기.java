import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] num;
	static int[][] sum;

	static void max() {
		for (int i = 1; i < n; i++) {
			sum[i][0] = Math.max(sum[i - 1][0], sum[i - 1][1]) + num[i][0];
			sum[i][1] = Math.max(sum[i - 1][0], Math.max(sum[i - 1][1], sum[i - 1][2])) + num[i][1];
			sum[i][2] = Math.max(sum[i - 1][1], sum[i - 1][2]) + num[i][2];
		}
	}

	static void min() {
		for (int i = 1; i < n; i++) {
			sum[i][0] = Math.min(sum[i - 1][0], sum[i - 1][1]) + num[i][0];
			sum[i][1] = Math.min(sum[i - 1][0], Math.min(sum[i - 1][1], sum[i - 1][2])) + num[i][1];
			sum[i][2] = Math.min(sum[i - 1][1], sum[i - 1][2]) + num[i][2];
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		num = new int[n][3];
		sum = new int[n][3];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 3; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		sum[0][0] = num[0][0];
		sum[0][1] = num[0][1];
		sum[0][2] = num[0][2];

		max();
		int maxScore = Math.max(sum[n - 1][0], Math.max(sum[n - 1][1], sum[n - 1][2]));

		min();
		int minScore = Math.min(sum[n - 1][0], Math.min(sum[n - 1][1], sum[n - 1][2]));

		System.out.println(maxScore + " " + minScore);
	}
}
