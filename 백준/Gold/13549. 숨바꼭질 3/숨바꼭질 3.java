import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		boolean[] visited = new boolean[100001];
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return Integer.compare(o1[1], o2[1]);
				}
				return Integer.compare(o1[0], o2[0]);
			}
		});

		pq.offer(new int[] { 0, n });
		visited[n] = true;

		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int time = now[0];
			int pos = now[1];

			if (pos == k) {
				System.out.println(time);
				break;
			}
			if (pos * 2 <= 100000 && !visited[pos * 2]) {
				pq.offer(new int[] { time, pos * 2 });
				visited[pos * 2] = true;
			}

			if (pos - 1 >= 0 && !visited[pos - 1]) {
				pq.offer(new int[] { time + 1, pos - 1 });
				visited[pos - 1] = true;
			}

			if (pos + 1 <= 100000 && !visited[pos + 1]) {
				pq.offer(new int[] { time + 1, pos + 1 });
				visited[pos + 1] = true;
			}
		}
	}
}
