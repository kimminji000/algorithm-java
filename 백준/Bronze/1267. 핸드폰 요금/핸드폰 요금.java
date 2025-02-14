import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int yMoney = 0, mMoney = 0;

		for (int i = 0; i < n; i++) {
			int time = Integer.parseInt(st.nextToken());
			yMoney += (time / 30 + 1) * 10;
			mMoney += (time / 60 + 1) * 15;
		}

		if (yMoney < mMoney) {
			System.out.println("Y " + yMoney);
		} else if (yMoney > mMoney) {
			System.out.println("M " + mMoney);
		} else {
			System.out.println("Y M " + yMoney);
		}
	}
}
