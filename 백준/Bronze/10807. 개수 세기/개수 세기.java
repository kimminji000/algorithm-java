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

		int[] num = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int v = Integer.parseInt(br.readLine());

		Arrays.sort(num);

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (num[i] == v) {
				cnt++;
			} else if (num[i] > v) {
				break;
			}
		}

		bw.write(Integer.toString(cnt));

		bw.flush();
		bw.close();
	}
}
