import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			String str = br.readLine();

			boolean[] visited = new boolean[26];
			boolean flag = true;

			visited[str.charAt(0) - 'a'] = true;

			for (int j = 1; j < str.length(); j++) {
				if (str.charAt(j) != str.charAt(j - 1)) {
					if (visited[str.charAt(j) - 'a']) {
						flag = false;
					} else {
						visited[str.charAt(j) - 'a'] = true;
					}
				}
			}

			if (flag) {
				cnt++;
			}
		}

		sb.append(cnt);

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
