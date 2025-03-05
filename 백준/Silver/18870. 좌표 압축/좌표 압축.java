import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static class Num {
		int value;
		int index;
		int compress;

		public Num(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		Num[] num = new Num[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			num[i] = new Num(Integer.parseInt(st.nextToken()), i);
		}

		Arrays.sort(num, new Comparator<Num>() {
			@Override
			public int compare(Num o1, Num o2) {
				return o1.value - o2.value;
			}
		});

		int cnt = 0;
		num[0].compress = cnt;

		for (int i = 1; i < n; i++) {
			if (num[i].value != num[i - 1].value) {
				num[i].compress = ++cnt;
			} else {
				num[i].compress = cnt;
			}
		}

		Arrays.sort(num, new Comparator<Num>() {
			@Override
			public int compare(Num o1, Num o2) {
				return o1.index - o2.index;
			}
		});

		for (int i = 0; i < n; i++) {
			sb.append(num[i].compress).append(" ");
		}

		System.out.println(sb.toString());

		br.close();
	}
}
