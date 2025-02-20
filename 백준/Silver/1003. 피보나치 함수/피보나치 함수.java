import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());

			int[] cnt0 = new int[n + 2];
			int[] cnt1 = new int[n + 2];

			cnt0[0] = 1;
			cnt1[1] = 1;

			for (int j = 2; j <= n; j++) {
				cnt0[j] = cnt0[j - 1] + cnt0[j - 2];
				cnt1[j] = cnt1[j - 1] + cnt1[j - 2];
			}

			sb.append(cnt0[n]).append(" ").append(cnt1[n]).append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}
}
