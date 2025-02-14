import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] pi = new int[n];
		for (int i = 0; i < n; i++) {
			pi[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(pi);

		int time = pi[0];
		for (int i = 1; i < n; i++) {
			pi[i] += pi[i - 1];
			time += pi[i];
		}

		bw.write(Integer.toString(time));
		bw.flush();
		br.close();
		bw.close();
	}
}
