import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	static boolean[][] visited;
	static int[][] house;
	static int n, houseCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());

		visited = new boolean[n][n];
		house = new int[n][n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();

			for (int j = 0; j < n; j++) {
				house[i][j] = Integer.parseInt(Character.toString(str.charAt(j)));
			}
		}

		StringBuilder sb = new StringBuilder();

		int cnt = 0;
		ArrayList<Integer> houseCntArr = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] == false && house[i][j] == 1) {
					cnt++;
					houseCnt = 0;
					dfs(i, j);
					houseCntArr.add(houseCnt);
				}
			}
		}

		sb.append(cnt).append("\n");
		houseCntArr.sort(null);
		for (int x : houseCntArr) {
			sb.append(x).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

	static void dfs(int x, int y) {
		if (visited[x][y] == true) {
			return;
		}

		visited[x][y] = true;
		houseCnt++;

		if (x - 1 >= 0 && house[x - 1][y] == 1)
			dfs(x - 1, y);
		if (x + 1 < n && house[x + 1][y] == 1)
			dfs(x + 1, y);
		if (y - 1 >= 0 && house[x][y - 1] == 1)
			dfs(x, y - 1);
		if (y + 1 < n && house[x][y + 1] == 1)
			dfs(x, y + 1);
	}
}
