import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		String[] nArr = new String[n];
		String[] mArr = new String[m];

		for (int i = 0; i < n; i++) {
			nArr[i] = br.readLine();
		}
		for (int i = 0; i < m; i++) {
			mArr[i] = br.readLine();
		}

		Arrays.sort(nArr);
		Arrays.sort(mArr);

		int cnt = 0;
		ArrayList<String> nmArr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (nArr[i].compareTo(mArr[j]) < 0) {
					break;
				} else if (nArr[i].equals(mArr[j])) {
					cnt++;
					nmArr.add(nArr[i]);
					break;
				}
			}
		}

		sb.append(cnt).append("\n");
		for (String str : nmArr) {
			sb.append(str).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
