import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(br.readLine());

		int length = 1;
		int count = 0;

		while (true) {
			int curr = (int) Math.pow(2, length);
			if (count + curr >= k) {
				break;
			}
			count += curr;
			length++;
		}

		int offset = k - count - 1;

		String binary = Integer.toBinaryString(offset);

		while (binary.length() < length) {
			binary = "0" + binary;
		}

		binary = binary.replace("0", "4");
		binary = binary.replace("1", "7");

		System.out.println(binary);
	}
}
