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

		String str = br.readLine();

		while (!str.equals("end")) {
			int mo = 0, moCnt = 0, jaCnt = 0;
			boolean flag = true;

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o'
						|| str.charAt(i) == 'u') {
					mo++;
					moCnt++;
					jaCnt = 0;
				} else {
					moCnt = 0;
					jaCnt++;
				}

				if (moCnt >= 3 || jaCnt >= 3) {
					flag = false;
				}

				if (i != 0) {
					if ((str.charAt(i) == str.charAt(i - 1))) {
						flag = false;

						if (str.charAt(i) == 'e' || str.charAt(i) == 'o') {
							flag = true;
						}
					}
				}

				if (flag == false) {
					break;
				}
			}

			if (mo == 0) {
				flag = false;
			}

			if (flag) {
				sb.append("<").append(str).append("> is acceptable.").append("\n");

			} else {
				sb.append("<").append(str).append("> is not acceptable.").append("\n");
			}

			str = br.readLine();
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
