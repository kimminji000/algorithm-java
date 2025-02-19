import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] cables = new int[k];

		for (int i = 0; i < k; i++) {
			cables[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(cables);

		long min = 1;
		long max = cables[k - 1];
		long mid = 0;

		while (min <= max) {
			mid = (max + min) / 2;

			int cnt = 0;
			for (int i = 0; i < k; i++) {
				cnt += cables[i] / mid;
			}

			if (cnt < n) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}

		sb.append(max);

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
