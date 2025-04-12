import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int c = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < c; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int[] score = new int[n];
			int sum = 0;

			for (int i = 0; i < n; i++) {
				score[i] = Integer.parseInt(st.nextToken());
				sum += score[i];
			}

			double avg = (double) sum / n;
			int cnt = 0;

			for (int i = 0; i < n; i++) {
				if (score[i] > avg) {
					cnt++;
				}
			}

			System.out.println(String.format("%.3f", (double) cnt / n * 100) + "%");
		}
	}
}
