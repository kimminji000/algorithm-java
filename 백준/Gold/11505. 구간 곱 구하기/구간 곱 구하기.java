import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] arr, tree;

	static long init(int node, int start, int end) {
		if (start == end) {
			return tree[node] = arr[start];
		}

		int mid = (start + end) / 2;
		return tree[node] = init(node * 2, start, mid) * init(node * 2 + 1, mid + 1, end) % 1000000007;
	}

	static long query(int node, int start, int end, int left, int right) {
		if (right < start || end < left) {
			return 1;
		}

		if (left <= start && end <= right) {
			return tree[node];
		}

		int mid = (start + end) / 2;
		return query(node * 2, start, mid, left, right) * query(node * 2 + 1, mid + 1, end, left, right) % 1000000007;
	}

	static long update(int node, int start, int end, int index, int dif) {
		if (start > index || end < index) {
			return tree[node];
		}

		if (start == end) {
			return tree[node] = arr[index] = dif;
		}

		int mid = (start + end) / 2;
		return tree[node] = update(node * 2, start, mid, index, dif) * update(node * 2 + 1, mid + 1, end, index, dif)
				% 1000000007;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		arr = new long[n + 1];
		tree = new long[4 * n];

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		init(1, 1, n);

		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 1) {
				update(1, 1, n, b, c);
			} else if (a == 2) {
				sb.append(query(1, 1, n, b, c)).append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}
