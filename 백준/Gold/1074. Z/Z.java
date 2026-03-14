import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int r, c, cnt = 0;

	private static void z(int n, int x, int y) {
		if (n == 0) {
			System.out.println(cnt);
			return;
		}

		int size = (int) Math.pow(2, n - 1);

		if (r < x + size) {
			if (c < y + size) {
				z(n - 1, x, y);
			} else {
				cnt += size * size;
				z(n - 1, x, y + size);
			}
		} else {
			if (c < y + size) {
				cnt += size * size * 2;
				z(n - 1, x + size, y);
			} else {
				cnt += size * size * 3;
				z(n - 1, x + size, y + size);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		z(n, 0, 0);

	}
}
