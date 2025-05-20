import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		for (int i = 1; i <= n; i++) {
			String str1 = br.readLine();
			String str2 = br.readLine();

			int[] alpha = new int[26];

			for (int j = 0; j < str1.length(); j++) {
				alpha[str1.charAt(j) - 'a']++;
			}

			for (int j = 0; j < str2.length(); j++) {
				alpha[str2.charAt(j) - 'a']--;
			}

			int cnt = 0;
			for (int j = 0; j < 26; j++) {
				cnt += Math.abs(alpha[j]);
			}

			sb.append("Case #").append(i).append(": ").append(cnt).append("\n");
		}

		System.out.println(sb.toString());
	}
}
