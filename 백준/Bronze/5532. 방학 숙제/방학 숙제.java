import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int l = Integer.parseInt(br.readLine());
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		int d = Integer.parseInt(br.readLine());

		int korean = a / c;
		if (a % c != 0) {
			korean++;
		}

		int math = b / d;
		if (b % d != 0) {
			math++;
		}
		System.out.println(l - Math.max(korean, math));
	}
}
