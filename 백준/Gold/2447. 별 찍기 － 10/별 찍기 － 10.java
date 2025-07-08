import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] board;

    static void draw(int x, int y, int size) {
        if (size == 1) {
            board[x][y] = '*';
            return;
        }

        int next = size / 3;

        for (int i = 0; i < 3; i++) {
            draw(x - 2 * next, y - i * next, next);
        }

        draw(x - next, y - 2 * next, size / 3);
        draw(x - next, y, size / 3);

        for (int i = 0; i < 3; i++) {
            draw(x, y - i * next, next);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        board = new char[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = ' ';
            }
        }

        draw(n, n, n);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
