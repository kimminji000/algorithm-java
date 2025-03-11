import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int cnt;
	static int r, c;

//	static void order(int n, int x, int y) { // 시간초과
//		if (n == 1) {
//			if (x == r && y == c) {
//				System.out.println(cnt);
//			}
//
//			cnt++;
//			return;
//		}
//
//		order(n / 2, x, y);
//		order(n / 2, x, y + n / 2);
//		order(n / 2, x + n / 2, y);
//		order(n / 2, x + n / 2, y + n / 2);
//	}

	static void order(int n, int x, int y) {
		if (n == 1) {
			System.out.println(cnt);
			return;
		}

		if (r < x + n / 2) {
			if (c < y + n / 2) { // 칸이 0영역에 있으면
				order(n / 2, x, y);
			} else { // 칸이 1영역에 있으면
				cnt += Math.pow(n / 2, 2);
				order(n / 2, x, y + n / 2);
			}
		} else {
			if (c < y + n / 2) { // 칸이 3영역에 있으면
				cnt += Math.pow(n / 2, 2) * 2;
				order(n / 2, x + n / 2, y);
			} else { // 칸이 4영역에 있으면
				cnt += Math.pow(n / 2, 2) * 3;
				order(n / 2, x + n / 2, y + n / 2);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		order((int) Math.pow(2, n), 0, 0);
	}
}
