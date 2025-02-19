import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
    static int[][] graph; // 생명력
    static int[][] hour; // 세포시간
    static int n, m, k;
 
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
 
    public static int bfs() {
        for (int time = 1; time <= k; time++) { // k시간 동안
 
            for (int i = 0; i < n + 400; i++) {
                for (int j = 0; j < m + 400; j++) {
                    if (graph[i][j] != 0) { // 비어있지 않을때
                        hour[i][j]++; // 시간이 흐름
 
                    }
                }
            }
 
            for (int i = 0; i < n + 400; i++) {
                for (int j = 0; j < m + 400; j++) {
 
                    if (graph[i][j] != 0 && graph[i][j] + 1 == hour[i][j]) { // 번식 상태
                        for (int k = 0; k < 4; k++) {
                            if (hour[i + dx[k]][j + dy[k]] == 0) { // 세포시간이 0일때
                                graph[i + dx[k]][j + dy[k]] = Math.max(graph[i][j], graph[i + dx[k]][j + dy[k]]);
                            }
                        }
                    }
                }
            }
        }
 
        int cnt = 0;
 
        for (int i = 0; i < n + 400; i++) {
            for (int j = 0; j < m + 400; j++) {
                if (graph[i][j] != 0 && hour[i][j] < 2 * graph[i][j]) { // 비어있지 않고 세포의 시간이 생명력의 2배미만
                    cnt++;
                }
            }
        }
 
        return cnt;
 
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
 
        int t = Integer.parseInt(br.readLine());
 
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
 
            graph = new int[n + 400][m + 400];
            hour = new int[n + 400][m + 400];
 
            for (int x = 0; x < n; x++) {
                st = new StringTokenizer(br.readLine());
 
                for (int y = 0; y < m; y++) {
                    graph[x + 200][y + 200] = Integer.parseInt(st.nextToken());
                }
            }
 
            int cnt = bfs();
 
            sb.append("#").append(i + 1).append(" ").append(cnt).append("\n");
 
        }
 
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
