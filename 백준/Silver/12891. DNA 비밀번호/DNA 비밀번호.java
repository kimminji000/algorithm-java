import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		String str = br.readLine();

		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		int startIndex = 1, aNum = 0, cNum = 0, gNum = 0, tNum = 0, cnt = 0;

		for (int i = 0; i < p; i++) {
			if (str.charAt(i) == 'A') {
				aNum++;
			} else if (str.charAt(i) == 'C') {
				cNum++;
			} else if (str.charAt(i) == 'G') {
				gNum++;
			} else if (str.charAt(i) == 'T') {
				tNum++;
			} else
				;
		}
		if (aNum >= a && cNum >= c && gNum >= g && tNum >= t) {
			cnt++;
		}

		while (startIndex + p <= s) {
			if (str.charAt(startIndex - 1) == 'A') {
				aNum--;
			} else if (str.charAt(startIndex - 1) == 'C') {
				cNum--;
			} else if (str.charAt(startIndex - 1) == 'G') {
				gNum--;
			} else if (str.charAt(startIndex - 1) == 'T') {
				tNum--;
			} else
				;

			if (str.charAt(startIndex + p - 1) == 'A') {
				aNum++;
			} else if (str.charAt(startIndex + p - 1) == 'C') {
				cNum++;
			} else if (str.charAt(startIndex + p - 1) == 'G') {
				gNum++;
			} else if (str.charAt(startIndex + p - 1) == 'T') {
				tNum++;
			} else
				;

			if (aNum >= a && cNum >= c && gNum >= g && tNum >= t) {
				cnt++;
			}
			startIndex++;
		}
		System.out.println(cnt);
	}
}
