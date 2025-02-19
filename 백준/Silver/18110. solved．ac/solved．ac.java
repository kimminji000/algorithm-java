import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[] score = new int[n];

		for (int i = 0; i < n; i++) {
			score[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(score);

		int cnt = (int) Math.round((double) n * 15 / 100);

		int sum = 0;

		for (int i = cnt; i < n - cnt; i++) {
			sum += score[i];
		}

		int avg = (int) Math.round((double) sum / (n - cnt * 2));

		sb.append(avg);

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
