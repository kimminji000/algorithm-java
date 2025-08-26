import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] num = new int[10];

		while (n > 0) {
			num[n % 10]++;
			n /= 10;
		}

		num[6] = (num[6] + num[9]) % 2 == 0 ? (num[6] + num[9]) / 2 : (num[6] + num[9]) / 2 + 1;
		num[9] = 0;

		int max = 0;

		for (int i = 0; i < 9; i++) {
			max = Math.max(max, num[i]);
		}

		System.out.println(max);
	}
}
