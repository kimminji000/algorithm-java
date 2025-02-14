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

		int king = Integer.parseInt(st.nextToken());
		int queen = Integer.parseInt(st.nextToken());
		int rook = Integer.parseInt(st.nextToken());
		int bishop = Integer.parseInt(st.nextToken());
		int knight = Integer.parseInt(st.nextToken());
		int pawn = Integer.parseInt(st.nextToken());

		sb.append(1 - king).append(" ");
		sb.append(1 - queen).append(" ");
		sb.append(2 - rook).append(" ");
		sb.append(2 - bishop).append(" ");
		sb.append(2 - knight).append(" ");
		sb.append(8 - pawn);

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
