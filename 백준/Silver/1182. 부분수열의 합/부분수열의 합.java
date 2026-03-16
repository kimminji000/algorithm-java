import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int cnt, s;
	static int[] num;

	private static void find(int n, int start, int sum) {
		if (sum == s) {
			cnt++;
		}
		for (int i = start; i < n; i++) {
			find(n, i + 1, sum + num[i]);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		num = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		find(n, 0, 0);

		if (s == 0) {
			cnt--; // 공집합 제거
		}

		System.out.println(cnt);
	}
}
