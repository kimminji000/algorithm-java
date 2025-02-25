import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static List<ArrayList<Integer>> combs;
	static ArrayList<Integer> comb;
	static boolean[] visited;
	static ArrayList<Integer>[] graph;
	static int[] population;

	static void combination(int start, int depth, int n, int r) {
		if (depth == r) {
			combs.add(new ArrayList<>(comb));
			return;
		}

		for (int i = start; i <= n; i++) {
			comb.add(i);
			combination(i + 1, depth + 1, n, r);
			comb.remove(comb.size() - 1);
		}
	}

	static int bfs(List<Integer> list, int sum) {
		Queue<Integer> queue = new LinkedList<>();

		queue.offer(list.get(0));
		visited[list.get(0)] = true;
		sum += population[list.get(0)];

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i = 0; i < graph[now].size(); i++) {
				int next = graph[now].get(i);

				if (list.contains(next) && !visited[next]) {
					queue.offer(next);
					visited[next] = true;
					sum += population[next];
				}
			}
		}

		return sum;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		population = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}

		graph = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<Integer>();

			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			for (int j = 0; j < m; j++) {
				graph[i].add(Integer.parseInt(st.nextToken()));
			}
		}

		combs = new ArrayList<ArrayList<Integer>>();
		comb = new ArrayList<Integer>();

		for (int i = 1; i < n; i++) {
			combination(1, 0, n, i);
		}

		boolean cant = true;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < combs.size(); i++) {
			List<Integer> aList = new ArrayList<>();
			List<Integer> bList = new ArrayList<>();

			visited = new boolean[n + 1];

			for (int j = 1; j <= n; j++) {
				if (combs.get(i).contains(j)) {
					aList.add(j);
				} else {
					bList.add(j);
				}
			}

			int aSum = bfs(aList, 0);
			int bSum = bfs(bList, 0);

			boolean flag = true;

			for (int j = 1; j <= n; j++) {
				if (!visited[j]) {
					flag = false;
					break;
				}
			}

			if (flag) {
				min = Math.min(min, Math.abs(aSum - bSum));
				cant = false;
			}
		}

		if (cant) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}

		br.close();
	}
}
