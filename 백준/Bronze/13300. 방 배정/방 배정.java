import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] boy = new int[7];
		int[] girl = new int[7];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());

			if (s == 0) {
				girl[Integer.parseInt(st.nextToken())]++;
			} else {
				boy[Integer.parseInt(st.nextToken())]++;
			}
		}

		int cnt = 0;

		for (int i = 1; i < 7; i++) {
			cnt += girl[i] % k == 0 ? girl[i] / k : girl[i] / k + 1;
		}
		for (int i = 1; i < 7; i++) {
			cnt += boy[i] % k == 0 ? boy[i] / k : boy[i] / k + 1;
		}
		
		System.out.println(cnt);
	}
}
