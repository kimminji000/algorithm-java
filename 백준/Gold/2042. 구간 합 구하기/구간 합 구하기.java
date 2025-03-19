import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] num;
	static long[] tree;

	static long init(int node, int start, int end) {
		if (start == end) {
			return tree[node] = num[start];
		}

		int mid = (start + end) / 2;

		return tree[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
	}

	public static long sum(int node, int start, int end, int left, int right) {
		if (left > end || right < start) { // 구간이 겹치지 않으면 0 반환
			return 0;
		}

		if (left <= start && end <= right) { // 현재 구간이 쿼리 구간에 완전히 포함되면 해당 값을 반환
			return tree[node];
		}

		int mid = (start + end) / 2;
		return sum(node * 2, start, mid, left, right) + sum(node * 2 + 1, mid + 1, end, left, right);
	}

	public static void update(int node, int start, int end, int idx, long dif) {
		if (idx < start || idx > end) { // 수정할 인덱스가 현재 구간에 없으면 종료
			return;
		}

		tree[node] += dif;

		if (start == end) { // 리프 노드라면 종료
			return;
		}

		int mid = (start + end) / 2;
		update(node * 2, start, mid, idx, dif);
		update(node * 2 + 1, mid + 1, end, idx, dif);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		num = new long[n + 1];

		for (int i = 1; i <= n; i++) {
			num[i] = Long.parseLong(br.readLine());
		}

		tree = new long[n * 4];

		init(1, 1, n);

		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());

			if (a == 1) {
				long dif = c - num[b];
				num[b] = c;
				update(1, 1, n, b, dif);
			} else if (a == 2) {
				sb.append(sum(1, 1, n, b, (int) c)).append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}
