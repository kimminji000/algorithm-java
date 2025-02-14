import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		String mul = Integer.toString(a * b * c);

		int[] num = new int[10];

		for (int i = 0; i < mul.length(); i++) {
			num[(int) (mul.charAt(i) - '0')]++;
		}

		for (int x : num) {
			bw.write(x + "\n");
		}

		bw.flush();
		bw.close();
	}
}
