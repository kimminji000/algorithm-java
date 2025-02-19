import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String n = br.readLine();

		int sum = 0;

		for (int i = 0; i < n.length(); i++) {
			sum += Integer.parseInt(Character.toString(n.charAt(i)));
		}

		sb.append(Integer.toString(sum));

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
