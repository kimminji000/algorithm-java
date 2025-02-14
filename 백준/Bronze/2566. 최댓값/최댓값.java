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

		int maxI = 1, maxJ = 1, max = 0;
		int[][] arr = new int[10][10];

		for (int i = 1; i <= 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] > max) {
					max = arr[i][j];
					maxI = i;
					maxJ = j;
				}
			}
		}

		sb.append(max).append("\n").append(maxI).append(" ").append(maxJ);

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
