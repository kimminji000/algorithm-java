import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int[][] block = new int[h][w];

		for (int i = 0; i < w; i++) {
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				block[j][i] = 1;
			}
		}

		int rain = 0, cnt = 0;
		boolean flag = false;

		for (int j = 0; j < h; j++) {
			for (int i = 0; i < w; i++) {
				if (block[j][i] == 1) {
					rain += cnt;
					cnt = 0;
					flag = true;
				} else if (flag) {
					cnt++;
				}
			}
			cnt = 0;
			flag = false;
		}

		sb.append(Integer.toString(rain));

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
