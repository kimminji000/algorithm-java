import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] str = new String[3];

		for (int i = 0; i < 3; i++) {
			str[i] = br.readLine();
		}

		for (int i = 0; i < 3; i++) {
			if (!(str[i].equals("FizzBuzz")) && !(str[i].equals("Fizz")) && !(str[i].equals("Buzz"))) {
				int num = Integer.parseInt(str[i]) + 3 - i;
				if (num % 3 == 0 && num % 5 == 0) {
					sb.append("FizzBuzz");
				} else if (num % 3 == 0) {
					sb.append("Fizz");
				} else if (num % 5 == 0) {
					sb.append("Buzz");
				} else {
					sb.append(num);
				}
				break;
			}
		}

		bw.append(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
