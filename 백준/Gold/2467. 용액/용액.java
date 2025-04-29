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
		int minSum = Integer.MAX_VALUE, bestL = 0, bestR = n - 1;

		while (left < right) {
			int sum = num[left] + num[right];

			if (minSum > Math.abs(sum)) {
				minSum = Math.abs(sum);
				bestL = left;
				bestR = right;
			}

			if (sum == 0) {
				break;
			} else if (sum < 0) {
				left++;
			} else {
				right--;
			}
		}

		System.out.println(num[bestL] + " " + num[bestR]);
	}
}
