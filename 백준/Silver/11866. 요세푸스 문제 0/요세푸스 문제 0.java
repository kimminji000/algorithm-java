import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<Integer>();

		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		sb.append("<");

		for (int i = 1; queue.size() > 1; i++) {
			if (i % k == 0) {
				sb.append(queue.poll()).append(", ");
			} else {
				queue.add(queue.poll());
			}
		}

		sb.append(queue.poll()).append(">");

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
