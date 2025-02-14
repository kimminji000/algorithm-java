import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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

		bw.write(Integer.toString(cnt));

		bw.flush();
		br.close();
		bw.close();
	}
}
