import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int point = 4;

		for (int i = 1; i <= n; i++) {
			point += Math.pow(2, i - 1) * (Math.pow(2, i - 1) + 1);
			point += (Math.pow(2, i) + 1) * Math.pow(2, i - 1);
		}

		System.out.println(point);
	}
}
