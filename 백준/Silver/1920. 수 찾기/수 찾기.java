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

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] nArr = new int[n];
		for (int i = 0; i < n; i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nArr);

		int m = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			int mNum = Integer.parseInt(st.nextToken());

			int min = 0, max = nArr.length - 1, median;

			while (min <= max) {
				median = (min + max) / 2;

				if (mNum == nArr[median]) {
					sb.append(1).append("\n");
					break;
				} else if (mNum < nArr[median]) {
					max = median - 1;
				} else if (mNum > nArr[median]) {
					min = median + 1;
				}
			}

			if (min > max) {
				sb.append(0).append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
