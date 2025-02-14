import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Member {
	int age;
	String name;

	Member(int age, String name) {
		this.age = age;
		this.name = name;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		List<Member> members = new ArrayList<>();

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			members.add(new Member(Integer.parseInt(st.nextToken()), st.nextToken()));
		}

		Collections.sort(members, new Comparator<Member>() {

			@Override
			public int compare(Member o1, Member o2) {
				return o1.age - o2.age;
			}
		});

		for (int i = 0; i < n; i++) {
			sb.append(members.get(i).age).append(" ").append(members.get(i).name).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
