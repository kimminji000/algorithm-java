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
			StringTokenizer st = new StringTokenizer(br.readLine());

			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			int aPrice, bPrice;

			aPrice = p * w;
			if (w <= r) {
				bPrice = q;
			} else {
				bPrice = q + s * (w - r);
			}

			if (aPrice < bPrice) {
				sb.append("#").append(i + 1).append(" ").append(aPrice).append("\n");
			} else {

				sb.append("#").append(i + 1).append(" ").append(bPrice).append("\n");
			}
		}

		bw.append(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
