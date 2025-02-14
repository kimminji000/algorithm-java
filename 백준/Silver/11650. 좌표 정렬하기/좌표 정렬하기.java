import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Coordinate {
	int x;
	int y;

	Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		List<Coordinate> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			list.add(new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		Collections.sort(list, new Comparator<Coordinate>() {

			@Override
			public int compare(Coordinate o1, Coordinate o2) {
				if (o1.x == o2.x) {
					return Integer.compare(o1.y, o2.y);
				}
				return Integer.compare(o1.x, o2.x);
			}
		});

		for (int i = 0; i < n; i++) {
			sb.append(list.get(i).x).append(" ").append(list.get(i).y).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
