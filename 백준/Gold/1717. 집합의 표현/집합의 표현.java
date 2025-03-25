import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] num;

	static void union(int a, int b) {
		// 대표 노드 찾아서 연결
		a = find(a);
		b = find(b);
		if (a != b) {
			num[b] = a; // 두개 연결
		}
	}

	static int find(int a) {
		if (a == num[a]) {
			return a;
		} else {
			return num[a] = find(num[a]); // value를 index로 바꿔서 또 찾기
		}
	}

	static boolean checkSame(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		num = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			num[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int c = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (c == 0) {
				union(a, b);
			} else if (c == 1) {
				if (checkSame(a, b)) {
					sb.append("YES").append("\n");
				} else {
					sb.append("NO").append("\n");
				}
			}
		}

		System.out.println(sb.toString());
	}
}
