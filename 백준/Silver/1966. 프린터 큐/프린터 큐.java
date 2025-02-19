import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			List<Integer> myQueue = new LinkedList<>();

			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				myQueue.add(num);
			}

			int cnt = -1, printCnt = 0;
			boolean flag = false;

			while (!myQueue.isEmpty()) {
				cnt++;
				if (cnt == m) {
					boolean priorityFlag = true;

					for (int k = 1; k < myQueue.size(); k++) {
						if (myQueue.get(0) < myQueue.get(k)) { // 수가 높을 수록 중요도가 높음
							myQueue.add(myQueue.get(0));
							myQueue.remove(0);
							m += myQueue.size();
							priorityFlag = false;
							break;
						}
					}

					if (priorityFlag) {
						myQueue.remove(0);
						sb.append(++printCnt).append("\n");
						flag = true;
						break;
					}
				} else {
					boolean priorityFlag = true;

					for (int k = 1; k < myQueue.size(); k++) {
						if (myQueue.get(0) < myQueue.get(k)) {
							myQueue.add(myQueue.get(0));
							myQueue.remove(0);
							priorityFlag = false;
							break;
						}
					}

					if (priorityFlag) {
						myQueue.remove(0);
						++printCnt;
					}
				}

				if (flag) {
					break;
				}
			}
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
