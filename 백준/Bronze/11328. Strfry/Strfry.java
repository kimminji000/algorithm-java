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

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			String str1 = st.nextToken();
			String str2 = st.nextToken();

			boolean flag = false;

			if (str1.length() == str2.length()) {
				flag = true;

				int[] alpha1 = new int[26];
				int[] alpha2 = new int[26];

				for (int j = 0; j < str1.length(); j++) {
					alpha1[str1.charAt(j) - 'a']++;
					alpha2[str2.charAt(j) - 'a']++;
				}

				for (int j = 0; j < 26; j++) {
					if (alpha1[j] != alpha2[j]) {
						flag = false;
						break;
					}
				}
			}

			if (flag) {
				bw.write("Possible\n");
			} else {
				bw.write("Impossible\n");
			}
		}

		bw.flush();
		bw.close();
	}
}
