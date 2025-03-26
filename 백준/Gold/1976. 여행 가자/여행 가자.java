import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] num;

	static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			num[b] = a;
		}
	}

	static int find(int a) {
		if (a == num[a]) {
			return a;
		}
		return num[a] = find(num[a]);
	}

	static boolean isUnion(int a, int b) {
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

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		num = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			num[i] = i;
		}

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= n; j++) {
				int a = Integer.parseInt(st.nextToken());

				if (a == 1) {
					union(i, j);
				}
			}
		}

		int[] city = new int[m];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < m; i++) {
			city[i] = Integer.parseInt(st.nextToken());
		}

		boolean flag = true;
		for (int i = 0; i < m - 1; i++) {
			if (!isUnion(city[i], city[i + 1])) {
				flag = false;
				break;
			}
		}

		if (flag) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
