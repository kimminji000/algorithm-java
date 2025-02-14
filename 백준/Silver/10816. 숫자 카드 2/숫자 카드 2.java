import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		HashMap<String, Integer> card = new HashMap<String, Integer>();

		for (int i = 0; i < n; i++) {
			String num = st.nextToken();
			if (card.containsKey(num)) {
				card.replace(num, card.get(num) + 1);
			} else {
				card.put(num, 1);
			}
		}

		int m = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < m; i++) {
			String num = st.nextToken();
			if (card.containsKey(num)) {
				sb.append(card.get(num)).append(" ");
			} else {
				sb.append(0).append(" ");
			}
		}

		bw.append(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
