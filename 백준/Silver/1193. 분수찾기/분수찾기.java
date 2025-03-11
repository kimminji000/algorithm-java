import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int x = Integer.parseInt(br.readLine());

		int i = 1;

		while (x - i > 0) {
			x -= i;
			i++;
		}

		if (i % 2 == 0) {
			System.out.println(x + "/" + (i - x + 1));
		} else {
			System.out.println((i - x + 1) + "/" + x);
		}
	}
}
