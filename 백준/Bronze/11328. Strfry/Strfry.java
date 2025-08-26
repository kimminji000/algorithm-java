import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			String str1 = st.nextToken();
			String str2 = st.nextToken();

			boolean flag = true;

			if (str1.length() != str2.length()) {
				flag = false;
			}

			if (flag) {
				int[] alpha1 = new int[26];
				int[] alpha2 = new int[26];

				for (int j = 0; j < str1.length(); j++) {
					alpha1[str1.charAt(j) - 'a']++;
				}
				for (int j = 0; j < str2.length(); j++) {
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
				System.out.println("Possible");
			} else {
				System.out.println("Impossible");
			}
		}
	}
}
