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

		for (int i = 0; i < t; i++) {
			int tNum = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			int[] score = new int[101];
			for (int j = 1; j <= 1000; j++) {
				score[Integer.parseInt(st.nextToken())] += 1;
			}

			int maxIndex = 0;
			for (int j = 1; j <= 100; j++) {
				if (score[j] >= score[maxIndex]) {
					maxIndex = j;
				}
			}

			sb.append("#").append(i + 1).append(" ").append(maxIndex).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
