import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
 
public class Solution {
    static int cnt = 0;
 
    static public void permutation(int depth, int n, int r, boolean[] visited, int[] weight, int leftSum,
            int rightSum) {
        if (depth == r) {
            cnt++;
            return;
        }
 
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
 
                permutation(depth + 1, n, r, visited, weight, leftSum + weight[i], rightSum);
 
                if (rightSum + weight[i] <= leftSum) {
                    permutation(depth + 1, n, r, visited, weight, leftSum, rightSum + weight[i]);
                }
 
                visited[i] = false;
            }
        }
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
 
        int t = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
 
            int[] weight = new int[n];
            boolean[] visited = new boolean[n];
 
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            for (int i = 0; i < n; i++) {
                weight[i] = Integer.parseInt(st.nextToken());
            }
 
            permutation(0, n, n, visited, weight, 0, 0);
 
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
            cnt = 0;
        }
 
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}