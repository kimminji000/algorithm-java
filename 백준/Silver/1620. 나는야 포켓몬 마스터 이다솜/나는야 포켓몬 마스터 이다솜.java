import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		HashMap<Integer, String> pokemonNum = new HashMap<>();
		HashMap<String, Integer> pokemonName = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			String name = br.readLine();
			pokemonNum.put(i, name);
			pokemonName.put(name, i);
		}

		for (int i = 0; i < m; i++) {
			String str = br.readLine();

			if (str.charAt(0) >= '1' && str.charAt(0) <= '9') {
				System.out.println(pokemonNum.get(Integer.parseInt(str)));
			} else {
				System.out.println(pokemonName.get(str));
			}
		}

		br.close();
	}
}
