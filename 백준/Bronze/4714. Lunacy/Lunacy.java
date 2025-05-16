import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			double x = Double.parseDouble(br.readLine());
			if (x < 0) {
				break;
			}
			double y = x * 0.167;

			System.out.printf("Objects weighing %.2f on Earth will weigh %.2f on the moon.\n", x, y);
		}
	}
}
