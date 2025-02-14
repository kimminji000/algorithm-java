import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] num = new int[5];

		for (int i = 0; i < 5; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(num);

		System.out.println((int) (Arrays.stream(num).average().getAsDouble()));
		System.out.println(num[2]);
	}
}
