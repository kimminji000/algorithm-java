import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int[] month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int days = y;
		for (int i = 1; i < x; i++) {
			days += month[i - 1];
		}

		if (days % 7 == 1) {
			System.out.println("MON");
		} else if (days % 7 == 2) {
			System.out.println("TUE");
		} else if (days % 7 == 3) {
			System.out.println("WED");
		} else if (days % 7 == 4) {
			System.out.println("THU");
		} else if (days % 7 == 5) {
			System.out.println("FRI");
		} else if (days % 7 == 6) {
			System.out.println("SAT");
		} else {
			System.out.println("SUN");
		}
	}
}
