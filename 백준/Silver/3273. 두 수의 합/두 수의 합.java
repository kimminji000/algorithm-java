import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

		Arrays.sort(num);

		int cnt = 0;
		int start = 0, end = n - 1;

		while (start < end) {
			if (num[start] + num[end] == x) {
				cnt++;
				start++;
				end--;
			} else if (num[start] + num[end] < x) {
				start++;
			} else {
				end--;
			}
		}

		System.out.println(cnt);
	}
}
