import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		int[] arr = new int[str.length()];

		for (int i = 0; i < str.length(); i++) {
			arr[i] = Integer.parseInt(Character.toString(str.charAt(i)));
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length() - 1; i++) {
			int maxIndex = i;
			for (int j = i; j < str.length(); j++) {
				if (arr[maxIndex] < arr[j])
					maxIndex = j;
			}

			int temp = arr[i];
			arr[i] = arr[maxIndex];
			arr[maxIndex] = temp;
			sb.append(arr[i]);
		}
		
		sb.append(arr[str.length() - 1]);
		System.out.println(sb.toString());
	}
}
