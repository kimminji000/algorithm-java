import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            if (r1 < r2) {
                int temp = x2;
                x2 = x1;
                x1 = temp;

                temp = y2;
                y2 = y1;
                y1 = temp;

                temp = r2;
                r2 = r1;
                r1 = temp;
            }

            double dist = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));

            if (x1 == x2 && y1 == y2) {
                if (r1 == r2) {
                    System.out.println(-1);
                } else {
                    System.out.println(0);
                }
            } else {
                if (dist < r1 + r2 && r1 < dist + r2) {
                    System.out.println(2);
                } else if (dist == r1 + r2 || r1 == dist + r2) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            }
        }
    }
}
