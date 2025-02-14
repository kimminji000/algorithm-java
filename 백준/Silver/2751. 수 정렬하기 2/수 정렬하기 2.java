import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		List<Integer> nums = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			nums.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(nums);

		for (int i = 0; i < n; i++) {
			sb.append(nums.get(i)).append("\n");
		}

		bw.append(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
