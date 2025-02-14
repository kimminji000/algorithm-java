import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int[] num = new int[3];

		for (int i = 0; i < 3; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		// Arrays.sort(num);

		for (int i = 0; i < num.length - 1; i++) {
			for (int j = num.length - 1; j > i; j--) {
				if (num[j] < num[j - 1]) {
					int temp = num[j];
					num[j] = num[j - 1];
					num[j - 1] = temp;
				}
			}
		}

		for (int x : num) {
			sb.append(x).append(" ");
		}

		System.out.println(sb.toString());
	}
}
