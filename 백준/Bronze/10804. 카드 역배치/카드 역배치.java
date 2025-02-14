import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] num = new int[21];

		for (int i = 1; i < 21; i++) {
			num[i] = i;
		}

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			while (a < b) {
				int temp = num[a];
				num[a] = num[b];
				num[b] = temp;

				a++;
				b--;
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < 21; i++) {
			sb.append(num[i]).append(" ");
		}

		System.out.println(sb);
	}
}
