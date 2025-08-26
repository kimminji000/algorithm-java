import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int x = Integer.parseInt(br.readLine());

		int[] number = new int[2000001];

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (num[i] <= x && number[x - num[i]] == 1) {
				cnt++;
			} else {
				number[num[i]]++;
			}
		}

		System.out.println(cnt);
	}
}