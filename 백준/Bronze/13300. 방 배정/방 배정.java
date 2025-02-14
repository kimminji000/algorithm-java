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

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] mNum = new int[7], wNum = new int[7];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			if (Integer.parseInt(st.nextToken()) == 0) {
				wNum[Integer.parseInt(st.nextToken())]++;
			} else {
				mNum[Integer.parseInt(st.nextToken())]++;
			}
		}

		int cnt = 0;

		for (int i = 1; i <= 6; i++) {
			if (wNum[i] == 0) {
				continue;
			} else if (wNum[i] % k == 0) {
				cnt += wNum[i] / k;

			} else {
				cnt += wNum[i] / k + 1;
			}

		}

		for (int i = 1; i <= 6; i++) {
			if (mNum[i] == 0) {
				continue;
			} else if (mNum[i] % k == 0) {
				cnt += mNum[i] / k;

			} else {
				cnt += mNum[i] / k + 1;
			}

		}

		bw.write(Integer.toString(cnt));

		bw.flush();
		bw.close();
	}
}
