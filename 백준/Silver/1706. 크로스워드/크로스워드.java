import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		char[][] puzzle = new char[r][c];

		for (int i = 0; i < r; i++) {
			String str = br.readLine();

			for (int j = 0; j < c; j++) {
				puzzle[i][j] = str.charAt(j);
			}
		}

		List<String> words = new ArrayList<>();

		for (int i = 0; i < r; i++) {
			StringBuilder sb = new StringBuilder();

			for (int j = 0; j < c; j++) {
				if (puzzle[i][j] == '#') {
					if (sb.toString().length() > 1) {
						words.add(sb.toString());
					}

					sb = new StringBuilder();
				} else {
					sb.append(puzzle[i][j]);
				}
			}

			if (sb.toString().length() > 1) {
				words.add(sb.toString());
			}
		}

		for (int j = 0; j < c; j++) {
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < r; i++) {
				if (puzzle[i][j] == '#') {
					if (sb.toString().length() > 1) {
						words.add(sb.toString());
					}

					sb = new StringBuilder();
				} else {
					sb.append(puzzle[i][j]);
				}
			}

			if (sb.toString().length() > 1) {
				words.add(sb.toString());
			}
		}

		Collections.sort(words);

		System.out.println(words.get(0));
	}
}
