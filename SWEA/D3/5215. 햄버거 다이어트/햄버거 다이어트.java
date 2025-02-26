import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static List<ArrayList<Integer>> combs;
	static ArrayList<Integer> comb;

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
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			int[] score = new int[n];
			int[] k = new int[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());

				score[i] = Integer.parseInt(st.nextToken());
				k[i] = Integer.parseInt(st.nextToken());
			}

			combs = new ArrayList<>();
			comb = new ArrayList<>();

			for (int i = 1; i <= n; i++) {
				combination(0, 0, n, i);
			}

			int scoreSum, kSum, bestScore = 0;

			for (ArrayList<Integer> i : combs) {
				scoreSum = 0;
				kSum = 0;
				boolean flag = true;

				for (int j = 0; j < i.size(); j++) {
					kSum += k[i.get(j)];

					if (kSum > l) {
						flag = false;
						break;
					}

					scoreSum += score[i.get(j)];
				}

				if (flag) {
					bestScore = Math.max(scoreSum, bestScore);
				}
			}

			sb.append("#").append(tc).append(" ").append(bestScore).append("\n");
		}

		System.out.println(sb.toString());

		br.close();
	}
}
