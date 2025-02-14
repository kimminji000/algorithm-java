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
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] num = new int[n];

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);

		int start = 0, end = n - 1, goodS = 0, goodE = n - 1;
		while (start < end) {
			if (num[start] + num[end] == 0) {
				goodS = start;
				goodE = end;
				break;
			} else if (num[start] + num[end] < 0) {
				if (Math.abs(num[start] + num[end]) < Math.abs(num[goodS] + num[goodE])) {
					goodS = start;
					goodE = end;
				}
				start++;
			} else {
				if (Math.abs(num[start] + num[end]) < Math.abs(num[goodS] + num[goodE])) {
					goodS = start;
					goodE = end;
				}
				end--;
			}
		}

		sb.append(num[goodS]).append(" ").append(num[goodE]);

		bw.append(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
