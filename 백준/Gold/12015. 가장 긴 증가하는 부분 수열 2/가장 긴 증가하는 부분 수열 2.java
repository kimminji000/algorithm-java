import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] num = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[n]; // 각 길이를 LIS로 만족하는 가장 끝에 오는 최소값
		int maxLen = 0;

		for (int i = 0; i < n; i++) {
			int pos = Arrays.binarySearch(dp, 0, maxLen, num[i]); // 못찾으면 (-(insertion point) - 1)
			// 주어진 배열에 key가 없을 경우 binarySearch는 해당 key가 삽입될 위치를 음수로 알려준다

			if (pos >= 0) { // 찾는 값이 있다면 값의 중복이 있다는 의미: 문제에 따라 다르게 처리
				continue;
			}

			int temp = Math.abs(pos) - 1;

			dp[temp] = num[i];

			if (temp == maxLen) { // 맨뒤에 추가된 상황이므로 사이즈 증가
				maxLen++;
			}
		}

		System.out.println(maxLen);
	}
}
