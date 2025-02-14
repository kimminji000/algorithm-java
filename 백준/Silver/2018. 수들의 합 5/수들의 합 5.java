import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		int n = Integer.parseInt(br.readLine());
//		int sum, cnt = 0;
//
//		for (int i = 1; i <= n; i++) {
//			sum = 0;
//			for (int j = i; j <= n; j++) {
//				sum += j;
//				if (sum > n) {
//					break;
//				}
//				else if (sum == n) {
//					cnt++;
//					break;
//				}
//				else;
//			}
//		}
//		System.out.println(cnt);

		int n = Integer.parseInt(br.readLine());
		int sum = 1, cnt = 1, startIndex = 1, endIndex = 1;

		while (endIndex != n) {
			if (sum > n) {
				sum -= startIndex;
				startIndex++;
			} else if (sum < n) {
				endIndex++;
				sum += endIndex;
			} else {
				cnt++;
				endIndex++;
				sum += endIndex;
			}
		}
		System.out.println(cnt);
	}
}
