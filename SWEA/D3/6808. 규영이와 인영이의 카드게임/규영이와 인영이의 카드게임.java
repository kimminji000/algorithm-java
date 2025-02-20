import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static List<int[]> perms;
	static int[] perm;
	static boolean[] visited;

	public static void permutation(int depth, int n, int r) {
		if (depth == r) {
			perms.add(perm.clone());
		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				perm[depth] = i;
				permutation(depth + 1, n, r);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int[] myCard = new int[9];
			perms = new ArrayList<>();
			perm = new int[9];
			visited = new boolean[19];

			for (int i = 0; i < 9; i++) {
				myCard[i] = Integer.parseInt(st.nextToken());
				visited[myCard[i]] = true;
			}

			permutation(0, 18, 9);

			int winCnt = 0, loseCnt = 0;
			for (int[] i : perms) {
				int mine = 0, yours = 0;

				for (int j = 0; j < 9; j++) {
					if (myCard[j] > i[j]) {
						mine += myCard[j] + i[j];
					} else {
						yours += myCard[j] + i[j];
					}
				}

				if (mine > yours) {
					winCnt++;
				} else if (mine < yours) {
					loseCnt++;
				}
			}

			sb.append("#").append(tc).append(" ").append(winCnt).append(" ").append(loseCnt).append("\n");
		}

		System.out.println(sb.toString());
		br.close();
	}
}
