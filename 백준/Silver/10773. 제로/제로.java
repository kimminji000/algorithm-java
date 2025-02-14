import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int sum = 0;

		int k = Integer.parseInt(br.readLine());
		int[] number = new int[k];

		int cnt = 0;

		for (int i = 0; i < k; i++) {
			int num = Integer.parseInt(br.readLine());

			if (num == 0) {
				number[--cnt] = 0;
			} else {
				number[cnt++] = num;
			}
		}

		for (int i = 0; i < k; i++) {
			sum += number[i];
		}

		sb.append(sum);

		bw.append(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
