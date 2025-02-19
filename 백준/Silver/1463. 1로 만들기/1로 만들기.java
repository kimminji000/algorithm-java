import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static public int bfs(int n) {
		Queue<int[]> queue = new ArrayDeque<>();

		queue.add(new int[] { n, 0 });

		int cnt = 0;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			int num = now[0];
			cnt = now[1];

			if (num == 1) {
				break;
			}

			if (num % 3 == 0) {
				queue.add(new int[] { num / 3, cnt + 1 });
			}

			if (num % 2 == 0) {
				queue.add(new int[] { num / 2, cnt + 1 });
			}

			queue.add(new int[] { num - 1, cnt + 1 });
		}

		return cnt;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int x = Integer.parseInt(br.readLine());

		int cnt = bfs(x);

		sb.append(cnt);

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
