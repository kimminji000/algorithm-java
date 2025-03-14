import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static TreeSet<Problem> problems;
	static HashMap<Integer, Integer> info;

	static class Problem implements Comparable<Problem> {
		int num;
		int level;

		public Problem(int num, int level) {
			super();
			this.num = num;
			this.level = level;
		}

		@Override
		public int compareTo(Problem o) {
			if (this.level == o.level) {
				return this.num - o.num;
			}
			return this.level - o.level;
		}
	}

	static int recommend(int x) {
		if (x == 1) {
			return problems.last().num;
		} else {
			return problems.first().num;
		}
	}

	static void add(int p, int l) {
		problems.add(new Problem(p, l));
		info.put(p, l);
	}

	static void solved(int p) {
		int l = info.get(p);
		problems.remove(new Problem(p, l));
		info.remove(p);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		problems = new TreeSet<>();
		info = new HashMap<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			problems.add(new Problem(p, l));
			info.put(p, l);
		}

		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();

			if (str.equals("recommend")) {
				int x = Integer.parseInt(st.nextToken());
				System.out.println(recommend(x));
			} else if (str.equals("add")) {
				int p = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());

				add(p, l);
			} else if (str.equals("solved")) {
				int p = Integer.parseInt(st.nextToken());
				solved(p);
			}
		}
	}
}
