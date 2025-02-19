import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			String str = br.readLine();

			int month = Integer.parseInt(str.substring(4, 6));
			int day = Integer.parseInt(str.substring(6));
			boolean flag = false;

			if (month >= 1 && month <= 12) {
				if (month == 2) {
					if (day >= 1 && day <= 28) {
						flag = true;
					}
				} else if (month == 4 || month == 6 || month == 9 || month == 11) {
					if (day >= 1 && day <= 30) {
						flag = true;
					}
				} else {
					if (day >= 1 && day <= 31) {
						flag = true;
					}
				}
			}

			if (flag) {
				sb.append("#").append(i + 1).append(" ").append(str.substring(0, 4)).append("/")
						.append(str.substring(4, 6)).append("/").append(str.substring(6)).append("\n");
			} else {
				sb.append("#").append(i + 1).append(" ").append("-1").append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
