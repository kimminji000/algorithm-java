import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> {
			int fristAbs = Math.abs(o1);
			int secondAbs = Math.abs(o2);
			if (fristAbs == secondAbs) {
				return o1 > o2 ? 1 : -1;
			}
			return fristAbs - secondAbs; // return이 음수: o1,o2 양수: o2,o1
		});

		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x != 0) {
				queue.add(x);
			} else {
				if (queue.size() == 0) {
					System.out.println("0");
				} else {
					System.out.println(queue.poll());
				}
			}
		}
	}
}
