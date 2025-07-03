import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String num = br.readLine();

		int answer = 0;

		if (num.charAt(1) == '0') {
			answer = Integer.parseInt(num.substring(0, 2)) + Integer.parseInt(num.substring(2, num.length()));
		} else {
			answer = Integer.parseInt(num.substring(0, 1)) + Integer.parseInt(num.substring(1, num.length()));
		}

		System.out.println(answer);
	}
}
