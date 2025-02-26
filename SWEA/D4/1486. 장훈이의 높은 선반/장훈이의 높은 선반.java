import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static ArrayList<ArrayList<Integer>> subsets;
	static ArrayList<Integer> sub;
	static boolean isSeleted[];

	static void powerSet(int depth, int n) {
		if (depth == n) {
			for (int i = 0; i < n; i++) {
				if (isSeleted[i] == true) {
					sub.add(i);
				}
			}
			subsets.add(new ArrayList<>(sub));
			sub.clear();
			return;
		}

		isSeleted[depth] = true;
		powerSet(depth + 1, n);

		isSeleted[depth] = false;
		powerSet(depth + 1, n);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int[] height = new int[n];

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				height[i] = Integer.parseInt(st.nextToken());
			}

			isSeleted = new boolean[n];
			subsets = new ArrayList<>();
			sub = new ArrayList<>();

			powerSet(0, n);

			int minHeight = Integer.MAX_VALUE;

			for (int i = 0; i < subsets.size(); i++) {
				int topHeight = 0;

				for (int j = 0; j < subsets.get(i).size(); j++) {
					topHeight += height[subsets.get(i).get(j)];
				}

				if (topHeight >= b) {
					minHeight = Math.min(topHeight, minHeight);
				}
			}

			sb.append("#").append(tc).append(" ").append(minHeight - b).append("\n");
		}

		System.out.println(sb.toString());

		br.close();
	}
}
