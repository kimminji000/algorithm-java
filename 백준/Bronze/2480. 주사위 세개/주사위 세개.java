import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] dice = new int[3];

		for (int i = 0; i < 3; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}

		if ((dice[0] == dice[1]) && (dice[0] == dice[2]))
			System.out.println(10000 + dice[0] * 1000);
		else if ((dice[0] == dice[1]) || (dice[0] == dice[2]))
			System.out.println(1000 + dice[0] * 100);
		else if (dice[1] == dice[2])
			System.out.println(1000 + dice[1] * 100);
		else
			System.out.println(Arrays.stream(dice).max().getAsInt() * 100);
	}
}
