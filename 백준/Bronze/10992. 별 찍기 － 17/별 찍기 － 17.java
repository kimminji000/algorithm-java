import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			if (i == 1 || i == n) {
				for (int j = 1; j <= n - i; j++) {
					sb.append(" ");
				}
				for (int k = 1; k <= 2 * i - 1; k++) {
					sb.append("*");
				}
				sb.append("\n");
			} else {
				for (int j = 1; j <= n - i; j++) {
					sb.append(" ");
				}
				sb.append("*");
				for (int j = 1; j <= 2 * (i - 1) - 1; j++) {
					sb.append(" ");
				}
				sb.append("*").append("\n");
			}
		}

		System.out.println(sb);

//		for (int i = 1; i < n; i++) {
//			if (i == 1) {
//				System.out.println(" ".repeat(n - i) + "*");
//			} else {
//				System.out.println(" ".repeat(n - i) + "*" + " ".repeat(2 * (i - 1) - 1) + "*");
//			}
//		}
//
//		System.out.println("*".repeat(2 * n - 1));

//		for (int i = 1; i <= n; i++) {
//			System.out.print(" ".repeat(n - i)); // 
//
//			if (i == 1 || i == n) {
//				System.out.print("*".repeat(2 * i - 1)); // 
//			} else {
//				System.out.print("*"); // 
//				System.out.print(" ".repeat(2 * (i - 1) - 1)); // 
//				System.out.print("*"); // 
//			}
//			System.out.println();
//		}
	}
}
