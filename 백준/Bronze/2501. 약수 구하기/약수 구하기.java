import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		List<Integer> num = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				num.add(i);
			}
		}

		if (num.size() < k) {
			sb.append(0);
		} else {
			sb.append(num.get(k - 1));
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
