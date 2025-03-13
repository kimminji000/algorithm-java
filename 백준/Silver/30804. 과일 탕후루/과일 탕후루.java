import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] fruit = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			fruit[i] = Integer.parseInt(st.nextToken());
		}

		int fruit1Index = -1;
		int fruit2Index = -1;
		int lastIndex = -1;

		int cnt = 0;
		int max = 0;

		for (int i = 0; i < n; i++) {
			if (fruit1Index == -1) {
				fruit1Index = i;
			} else if (fruit[fruit1Index] != fruit[i] && fruit2Index == -1) {
				fruit2Index = i;
			}

			if (fruit[fruit1Index] == fruit[i]) {
				cnt++;
			} else if (fruit[fruit2Index] == fruit[i]) {
				cnt++;
			} else {
				max = Math.max(max, cnt);
				fruit1Index = lastIndex;
				fruit2Index = i;
				cnt = fruit2Index - fruit1Index + 1;
			}

			if (i != 0 && fruit[i - 1] != fruit[i]) {
				lastIndex = i;
			}
		}
		max = Math.max(max, cnt);

		System.out.println(max);
	}
}
