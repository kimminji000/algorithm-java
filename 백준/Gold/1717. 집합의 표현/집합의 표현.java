import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static int[] rank;

	static void makeSet(int size) {
		parent = new int[size];
		rank = new int[size];
		for (int i = 0; i < size; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}

	static void union(int a, int b) { // 대표 노드 찾아서 연결
		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB) {
			return;
		}

		if (rank[rootA] < rank[rootB]) { // a의 높이가 더 작으면
			parent[rootA] = rootB; // b에 a를 붙임
		} else if (rank[rootA] > rank[rootB]) { // b의 높이가 더 작으면
			parent[rootB] = rootA;// a에 b를 붙임
		} else { // 같다면
			parent[rootB] = rootA; // a에 b를 붙이고
			rank[rootA]++; // a의 높이를 하나 높임
		}
	}

	static int find(int a) {
		if (a == parent[a]) {
			return a;
		}
		return parent[a] = find(parent[a]); // value를 index로 바꿔서 또 찾기, 경로 압축
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

		makeSet(n + 1);

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
