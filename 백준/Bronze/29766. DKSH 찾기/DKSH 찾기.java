import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		int cnt = 0;

		for (int i = 0; i <= str.length() - 4; i++) {
			if (str.substring(i, i + 4).equals("DKSH")) {
				cnt++;
			}
		}

		System.out.println(cnt);
	}
}
