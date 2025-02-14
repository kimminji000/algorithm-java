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

		double creditSum = 0, scoreSum = 0;

		for (int i = 0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			st.nextToken();
			double credit = Double.parseDouble(st.nextToken());
			String grade = st.nextToken();

			if (grade.equals("A+")) {
				creditSum += credit;
				scoreSum += credit * 4.5;
			} else if (grade.equals("A0")) {
				creditSum += credit;
				scoreSum += credit * 4.0;
			} else if (grade.equals("B+")) {
				creditSum += credit;
				scoreSum += credit * 3.5;
			} else if (grade.equals("B0")) {
				creditSum += credit;
				scoreSum += credit * 3.0;
			} else if (grade.equals("C+")) {
				creditSum += credit;
				scoreSum += credit * 2.5;
			} else if (grade.equals("C0")) {
				creditSum += credit;
				scoreSum += credit * 2.0;
			} else if (grade.equals("D+")) {
				creditSum += credit;
				scoreSum += credit * 1.5;
			} else if (grade.equals("D0")) {
				creditSum += credit;
				scoreSum += credit * 1.0;
			} else if (grade.equals("F")) {
				creditSum += credit;
				scoreSum += credit * 0.0;
			}

		}

		sb.append(scoreSum / creditSum);

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
