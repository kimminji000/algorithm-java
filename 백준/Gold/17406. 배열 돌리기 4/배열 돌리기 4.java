import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<int[]> rcs = new ArrayList<>();
	static boolean[] visited;
	static List<int[]> sequences = new ArrayList<>();
	static int[] seq;

	static public void permutation(int depth, int n, int r) {
		if (r == depth) {
			sequences.add(seq.clone());
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				seq[depth] = i;
				permutation(depth + 1, n, r);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] map = new int[n + 1][m + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 회전 연산 정보
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());

			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			rcs.add(new int[] { r, c, s });
		}

		// 회전 연산 순서 순열로
		seq = new int[k];
		visited = new boolean[k];

		permutation(0, k, k);

		int min = Integer.MAX_VALUE;

		// 연산 순서 순열 개수많큼 반복
		for (int i = 0; i < sequences.size(); i++) {
			int[][] tempMap = new int[n + 1][m + 1];

			for (int a = 1; a <= n; a++) {
				for (int b = 1; b <= m; b++) {
					tempMap[a][b] = map[a][b];
				}
			}

			for (int j = 0; j < k; j++) {
				int r = rcs.get(sequences.get(i)[j])[0];
				int c = rcs.get(sequences.get(i)[j])[1];
				int s = rcs.get(sequences.get(i)[j])[2];

				for (int l = 1; l <= s; l++) {
					int temp = tempMap[r - l][c - l];

					// 아래에 있는 값을 내 값으로
					for (int a = -l; a < l; a++) {
						tempMap[r + a][c - l] = tempMap[r + a + 1][c - l];
					}

					// 오른쪽에 있는 값을 내 값으로
					for (int a = -l; a < l; a++) {
						tempMap[r + l][c + a] = tempMap[r + l][c + a + 1];
					}

					// 위에 있는 값을 내 값으로
					for (int a = l; a > -l; a--) {
						tempMap[r + a][c + l] = tempMap[r + a - 1][c + l];
					}

					// 왼쪽에 있는 값을 내 값으로
					for (int a = l; a > -l + 1; a--) {
						tempMap[r - l][c + a] = tempMap[r - l][c + a - 1];
					}

					tempMap[r - l][c - l + 1] = temp;
				}
			}

			for (int a = 1; a <= n; a++) {
				int sum = 0;

				for (int b = 1; b <= m; b++) {
					sum += tempMap[a][b];
				}

				min = Math.min(min, sum);
			}
		}

		sb.append(min);

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
