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

		String num[] = br.readLine().split(" ");

		String str = "mixed";

		int asc = 0;
		int desc = 0;

		if (num[0].equals("1")) {
			for (int i = 0; i < num.length - 1; i++) {
				if (Integer.parseInt(num[i]) < Integer.parseInt(num[i + 1])) {
					asc += 1;
				}
			}
		} else if (num[0].equals("8")) {
			for (int i = 0; i < num.length - 1; i++) {
				if (Integer.parseInt(num[i]) > Integer.parseInt(num[i + 1])) {
					desc += 1;
				}
			}
		}

		if (asc == 7) {
			str = "ascending";
		}
		if (desc == 7) {
			str = "descending";
		}

		sb.append(str);

		bw.append(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
