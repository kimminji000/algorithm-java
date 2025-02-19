import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int sum = 0;

		int[] nums = new int[n];

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());

			nums[i] = num;
			sum += num;
		}

		Arrays.sort(nums);

		int cnt = 1, modeCnt = 1, modeIndex = 0;
		boolean flag = true;

		for (int i = 1; i < n; i++) {
			if (nums[i] == nums[i - 1]) {
				cnt++;
			} else {
				cnt = 1;
			}

			if (cnt > modeCnt) {
				modeCnt = cnt;
				modeIndex = i;
				flag = true;
			} else if (cnt == modeCnt && flag) {
				modeIndex = i;
				flag = false;
			}
		}

		int num1 = (int) Math.round((double) sum / n);
		int num2 = nums[n / 2];
		int num3 = nums[modeIndex];
		int num4 = nums[n - 1] - nums[0];

		sb.append(num1).append("\n").append(num2).append("\n").append(num3).append("\n").append(num4);

		bw.append(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
