import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();

		sb.append(str.charAt(0) == 'E' ? 'I' : 'E');
		sb.append(str.charAt(1) == 'S' ? 'N' : 'S');
		sb.append(str.charAt(2) == 'T' ? 'F' : 'T');
		sb.append(str.charAt(3) == 'J' ? 'P' : 'J');

		System.out.println(sb.toString());
	}
}
