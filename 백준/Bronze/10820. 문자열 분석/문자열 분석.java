import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;

		while ((str = br.readLine()) != null) {
			int[] arr = new int[4];

			for (int i = 0; i < str.length(); i++) {
				if ('a' <= str.charAt(i) && str.charAt(i) <= 'z')
					arr[0]++;
				else if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z')
					arr[1]++;
				else if ('0' <= str.charAt(i) && str.charAt(i) <= '9')
					arr[2]++;
				else if (str.charAt(i) == ' ')
					arr[3]++;
			}

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < 4; i++) {
				sb.append(arr[i]).append(" ");
			}

			System.out.println(sb.toString().trim());
		}
	}
}
