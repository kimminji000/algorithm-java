import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String num = br.readLine();

//		char[] cNum = num.toCharArray();
//
//		int sum = 0;
//		for (int i = 0; i < n; i++) {
//			sum += cNum[i] - '0';
//		}

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += Integer.parseInt(Character.toString(num.charAt(i)));
		}

		System.out.println(sum);
	}
}
