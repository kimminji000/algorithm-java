import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		int cnt = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
        
		Arrays.sort(num);

		int startIndex = 0, endIndex = n - 1;
		
		while (startIndex < endIndex) {
			if (num[startIndex] + num[endIndex] < m) {
				startIndex++;
			} else if (num[startIndex] + num[endIndex] > m) {
				endIndex--;
			} else {
				cnt++;
				startIndex++;
				endIndex--;
			}
		}
		System.out.println(cnt);
	}
}
