import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Person {
	int weight;
	int height;
	int rank = 0;

	Person(int weight, int height) {
		this.weight = weight;
		this.height = height;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		Person[] people = new Person[n];

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			people[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		int cnt;
		for (int i = 0; i < n; i++) {
			cnt = 1;
			for (int j = 0; j < n; j++) {
				if (people[i].weight < people[j].weight && people[i].height < people[j].height) {
					cnt++;
				}
			}
			people[i].rank = cnt;
		}

		for (int i = 0; i < n; i++) {
			sb.append(people[i].rank).append(" ");
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
