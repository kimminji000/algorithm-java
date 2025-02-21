import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int m = Integer.parseInt(br.readLine());

		Set<Integer> arr = new HashSet<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			String str = st.nextToken();
			int x;

			switch (str) {
			case ("add"):
				x = Integer.parseInt(st.nextToken());
				arr.add(x);
				break;
			case ("remove"):
				x = Integer.parseInt(st.nextToken());
				arr.remove(x);
				break;
			case ("check"):
				x = Integer.parseInt(st.nextToken());
				if (arr.contains(x)) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
				break;
			case ("toggle"):
				x = Integer.parseInt(st.nextToken());
				if (arr.contains(x)) {
					arr.remove(x);
				} else {
					arr.add(x);
				}
				break;
			case ("all"):
				arr.clear();
				for (int j = 1; j <= 20; j++) {
					arr.add(j);
				}
				break;
			case ("empty"):
				arr.clear();
				break;
			}
		}

		System.out.println(sb.toString());

		br.close();
	}
}
