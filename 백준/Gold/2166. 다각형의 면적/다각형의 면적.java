import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		long[][] point = new long[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			point[i][0] = Long.parseLong(st.nextToken());
			point[i][1] = Long.parseLong(st.nextToken());
		}

		double area = 0;

		for (int i = 0; i < n; i++) {
			area += point[i][0] * point[(i + 1) % n][1];
			area -= point[(i + 1) % n][0] * point[i][1];
		}

		System.out.printf("%.1f", Math.abs(area / 2));
	}
}
