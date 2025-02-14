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

		String str = br.readLine();

		int cnt = 0;

		for (int i = 0; i < str.length(); i++) {
			if (i == str.length() - 1) {
				cnt++;
			} else if (i == str.length() - 2) {
				if (i != str.length() - 1 && str.charAt(i) == 'c' && str.charAt(i + 1) == '=') {
					cnt++;
					i++;
				} else if (str.charAt(i) == 'c' && str.charAt(i + 1) == '-') {
					cnt++;
					i++;
				} else if (str.charAt(i) == 'd' && str.charAt(i + 1) == '-') {
					cnt++;
					i++;
				} else if (str.charAt(i) == 'l' && str.charAt(i + 1) == 'j') {
					cnt++;
					i++;
				} else if (str.charAt(i) == 'n' && str.charAt(i + 1) == 'j') {
					cnt++;
					i++;
				} else if (str.charAt(i) == 's' && str.charAt(i + 1) == '=') {
					cnt++;
					i++;
				} else if (str.charAt(i) == 'z' && str.charAt(i + 1) == '=') {
					cnt++;
					i++;
				} else {
					cnt++;
				}
			} else {
				if (i != str.length() - 1 && str.charAt(i) == 'c' && str.charAt(i + 1) == '=') {
					cnt++;
					i++;
				} else if (str.charAt(i) == 'c' && str.charAt(i + 1) == '-') {
					cnt++;
					i++;
				} else if (str.charAt(i) == 'd' && str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=') {
					cnt++;
					i += 2;
				} else if (str.charAt(i) == 'd' && str.charAt(i + 1) == '-') {
					cnt++;
					i++;
				} else if (str.charAt(i) == 'l' && str.charAt(i + 1) == 'j') {
					cnt++;
					i++;
				} else if (str.charAt(i) == 'n' && str.charAt(i + 1) == 'j') {
					cnt++;
					i++;
				} else if (str.charAt(i) == 's' && str.charAt(i + 1) == '=') {
					cnt++;
					i++;
				} else if (str.charAt(i) == 'z' && str.charAt(i + 1) == '=') {
					cnt++;
					i++;
				} else {
					cnt++;
				}
			}
		}

		sb.append(cnt);

//		str = str.replaceAll("c=", "a");
//		str = str.replaceAll("c-", "a");
//		str = str.replaceAll("dz=", "a");
//		str = str.replaceAll("d-", "a");
//		str = str.replaceAll("lj", "a");
//		str = str.replaceAll("nj", "a");
//		str = str.replaceAll("s=", "a");
//		str = str.replaceAll("z=", "a");
//
//		sb.append(str.length());

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
