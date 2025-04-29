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

		Arrays.sort(num);

		int left = 0, right = n - 1;
		int sum = Integer.MAX_VALUE, bestL = 0, bestR = n - 1;

		while (left < right) {
			if (num[left] + num[right] == 0) {
				sum = 0;
				bestL = left;
				bestR = right;
				break;
			}

			if (sum > Math.abs(num[left] + num[right])) {
				sum = Math.abs(num[left] + num[right]);
				bestL = left;
				bestR = right;
			}

			if (num[left] + num[right] < 0) {
				left++;
			} else {
				right--;
			}
		}

		System.out.println(num[bestL] + " " + num[bestR]);
	}
}
