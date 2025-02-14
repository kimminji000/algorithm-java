
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

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] num = new int[n];

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;

		for (int i = 0; i < n; i++) {
			boolean flag = false;

			for (int j = 2; j < num[i]; j++) {
				if (num[i] % j == 0) {
					flag = true;
					break;
				}
			}

			if (num[i] != 1 && flag == false) {
				cnt++;
			}
		}

		sb.append(cnt);

		bw.append(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
