import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		int[] nums = new int[n + 2];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int sum = nums[0], front = 0, back = 0, minLength = Integer.MAX_VALUE;

		while (back < n) {
			if (sum < s) {
				back++;
				sum += nums[back];
			} else {
				minLength = Math.min(minLength, back - front + 1);
				sum -= nums[front];

				if (back == front) {
					back++;
				}
				front++;
			}
		}

		if (minLength == Integer.MAX_VALUE) {
			System.out.println(0);
		} else {
			System.out.println(minLength);
		}
	}
}
