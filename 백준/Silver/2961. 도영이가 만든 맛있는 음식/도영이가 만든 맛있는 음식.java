import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<ArrayList<Integer>> combs = new ArrayList<>();
	static ArrayList<Integer> comb = new ArrayList<>();

	static void combination(int depth, int start, int n, int r) {
		if (depth == r) {
			combs.add(new ArrayList<>(comb));
			return;
		}

		for (int i = start; i < n; i++) {
			comb.add(i);
			combination(depth + 1, i + 1, n, r);
			comb.remove(comb.size() - 1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] flavor = new int[n][2];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			flavor[i][0] = Integer.parseInt(st.nextToken());
			flavor[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			combination(0, 0, n, i);
		}

		int diff = Integer.MAX_VALUE;

		for (ArrayList<Integer> i : combs) {
			int sSum = 1, bSum = 0;

			for (int j = 0; j < i.size(); j++) {
				sSum *= flavor[i.get(j)][0];
				bSum += flavor[i.get(j)][1];
			}

			if (Math.abs(sSum - bSum) < diff) {
				diff = Math.abs(sSum - bSum);
			}
		}

		System.out.println(diff);

		br.close();
	}
}
