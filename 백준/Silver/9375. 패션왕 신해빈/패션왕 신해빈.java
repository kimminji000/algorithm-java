import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());

			Map<String, Integer> category = new LinkedHashMap<>();

			for (int j = 0; j < n; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				st.nextToken(); // name
				String cate = st.nextToken();

				if (category.containsKey(cate)) {
					category.put(cate, category.get(cate) + 1);
				} else {
					category.put(cate, 1);
				}
			}

			int cnt = 1;

			for (int j : category.values()) {
				cnt *= (j + 1);
			}

			sb.append(cnt - 1).append("\n");

		}

		System.out.println(sb.toString());

		br.close();
	}
}
