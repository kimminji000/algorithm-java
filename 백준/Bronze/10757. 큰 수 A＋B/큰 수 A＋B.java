import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		String n1 = st.nextToken();
		String n2 = st.nextToken();

		int length = Math.max(n1.length(), n2.length());

		int[] num1 = new int[length + 1];
		for (int i = n1.length() - 1, index = length; i >= 0; i--, index--) {
			num1[index] = Integer.parseInt(Character.toString(n1.charAt(i)));
		}

		int[] num2 = new int[length + 1];
		for (int i = n2.length() - 1, index = length; i >= 0; i--, index--) {
			num2[index] = Integer.parseInt(Character.toString(n2.charAt(i)));
		}

		int[] num = new int[length + 1];

		for (int i = length; i >= 1; i--) {
			num[i - 1] = (num[i] + num1[i] + num2[i]) / 10;
			num[i] = (num[i] + num1[i] + num2[i]) % 10;
		}

		if (num[0] != 0) {
			sb.append(num[0]);
		}
		for (int i = 1; i < length + 1; i++) {
			sb.append(num[i]);
		}

		System.out.println(sb.toString());
	}
}
