import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[] cnt = new int[n + 1];

		cnt[1] = 1;
		
		if (n != 1) {
			cnt[2] = 2;

			for (int i = 3; i <= n; i++) {
				cnt[i] = (cnt[i - 1] + cnt[i - 2]) % 10007;
			}
		}

		sb.append(Integer.toString(cnt[n]));

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
