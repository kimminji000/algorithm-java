import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] basket = new int[n + 1];
		for (int a = 1; a <= n; a++) {
			basket[a] = a;
		}

		for (int a = 0; a < m; a++) {
			st = new StringTokenizer(br.readLine());

			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			while (i < j) {
				int temp = basket[i];
				basket[i] = basket[j];
				basket[j] = temp;
				i++;
				j--;
			}
		}

		for (int a = 1; a <= n; a++) {
			sb.append(basket[a]).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
