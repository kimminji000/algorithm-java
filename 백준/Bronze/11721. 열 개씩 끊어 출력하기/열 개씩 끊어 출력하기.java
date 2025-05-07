import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		int i;
		for (i = 0; i < str.length() / 10; i++) {
			System.out.println(str.substring(i * 10, (i + 1) * 10));
		}
		System.out.println(str.substring(i * 10, str.length()));
	}
}
