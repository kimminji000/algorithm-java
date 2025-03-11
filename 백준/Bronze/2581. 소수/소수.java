import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());

		List<Integer> prime = new ArrayList<>();

		int sum = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 2; i <= n; i++) {
			boolean flag = true;

			for (int j : prime) {
				if (i % j == 0) {
					flag = false;
					break;
				}
			}

			if (flag) {
				prime.add(i);

				if (i >= m) {
					sum += i;
					min = Math.min(min, i);
				}
			}
		}

		if (sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}
