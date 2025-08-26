import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str1 = br.readLine();
		String str2 = br.readLine();

		int[] alpha = new int[26];

		for (int i = 0; i < str1.length(); i++) {
			alpha[str1.charAt(i) - 'a']++;
		}
		for (int i = 0; i < str2.length(); i++) {
			alpha[str2.charAt(i) - 'a']--;
		}

		int cnt = 0;

		for (int i = 0; i < 26; i++) {
			cnt += Math.abs(alpha[i]);
		}

		System.out.println(cnt);
	}
}
