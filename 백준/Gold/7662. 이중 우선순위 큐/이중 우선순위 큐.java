import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static class Number implements Comparable<Number> {
		int index;
		int num;

		public Number(int index, int num) {
			super();
			this.index = index;
			this.num = num;
		}

		@Override
		public int compareTo(Number o) {
			if (this.num == o.num) {
				return Integer.compare(this.index, o.index);
			}
			return Integer.compare(this.num, o.num);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			TreeSet<Number> treeSet = new TreeSet<>();
			int index = 0;

			int k = Integer.parseInt(br.readLine());

			for (int i = 0; i < k; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				char alphbet = st.nextToken().charAt(0);
				int n = Integer.parseInt(st.nextToken());

				if (alphbet == 'I') {
					treeSet.add(new Number(index++, n));
				} else if (alphbet == 'D') {
					if (!treeSet.isEmpty()) {
						if (n == 1) {
							treeSet.pollLast();
						} else if (n == -1) {
							treeSet.pollFirst();
						}
					}
				}
			}

			if (treeSet.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				sb.append(treeSet.last().num).append(" ").append(treeSet.first().num).append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}
