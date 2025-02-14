import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();

		String[] minusArr = str.split("\\-");

		int result = 0;

		for (int i = 0; i < minusArr.length; i++) {
			if (i == 0) {
				String[] plusArr = minusArr[i].split("\\+");

				for (int j = 0; j < plusArr.length; j++) {
					result += Integer.parseInt(plusArr[j]);
				}
			} else {
				String[] plusArr = minusArr[i].split("\\+");

				for (int j = 0; j < plusArr.length; j++) {
					result -= Integer.parseInt(plusArr[j]);
				}
			}
		}

		bw.write(Integer.toString(result));
		bw.flush();
		br.close();
		bw.close();
	}
}
