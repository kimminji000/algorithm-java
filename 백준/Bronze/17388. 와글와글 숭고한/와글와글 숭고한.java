import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int s = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		if (s + k + h >= 100) {
			System.out.println("OK");
		} else if (Math.min(s, Math.min(k, h)) == s) {
			System.out.println("Soongsil");
		} else if (Math.min(s, Math.min(k, h)) == k) {
			System.out.println("Korea");
		} else if (Math.min(s, Math.min(k, h)) == h) {
			System.out.println("Hanyang");
		}
	}
}
