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

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] size = new int[6];

		for (int i = 0; i < 6; i++) {
			size[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		int tshirt = 0;

		for (int i = 0; i < size.length; i++) {
			tshirt += size[i] / t + (size[i] % t == 0 ? 0 : 1);
		}

		int bundle = n / p;
		int pen = n % p;

		sb.append(tshirt).append("\n");
		sb.append(bundle).append(" ").append(pen);

		bw.append(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}