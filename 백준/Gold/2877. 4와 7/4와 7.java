import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(br.readLine());

		String res = "";

		while (k > 0) {
			int n = k % 2; // 짝홀 판단
			k = k / 2;

			if (n == 0) {
				k--;
				res = "7" + res;
			} else
				res = "4" + res;
		}

		System.out.println(res);
	}
}
