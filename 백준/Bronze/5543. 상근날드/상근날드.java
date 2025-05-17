import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int burger1 = Integer.parseInt(br.readLine());
		int burger2 = Integer.parseInt(br.readLine());
		int burger3 = Integer.parseInt(br.readLine());
		int cola = Integer.parseInt(br.readLine());
		int cider = Integer.parseInt(br.readLine());

		System.out.println(Math.min(burger1, Math.min(burger2, burger3)) + Math.min(cola, cider) - 50);
	}
}
