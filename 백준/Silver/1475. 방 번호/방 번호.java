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

		String n = br.readLine();

		int[] num = new int[10];

		for (int i = 0; i < n.length(); i++) {
			num[(int) (n.charAt(i) - '0')]++;
		}

		if ((num[6] + num[9]) % 2 != 0) {
			num[6] = (num[6] + num[9]) / 2 + 1;
		} else {
			num[6] = (num[6] + num[9]) / 2;
		}
		num[9] = num[6];

		bw.write(Integer.toString(Arrays.stream(num).max().getAsInt()));

		bw.flush();
		bw.close();
	}
}
