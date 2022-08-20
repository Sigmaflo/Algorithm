import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[][] dp;

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }

    static int rec_func(int n, int r) {
        if (dp[n][r] > 0) return dp[n][r];
        if (n == r || r == 0) return dp[n][r] = 1;
        return dp[n][r] = rec_func(n - 1, r - 1) + rec_func(n - 1, r);
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        dp = new int[30][30];
        for (int tt = 0; tt < T; tt++) {
            input();
            sb.append(rec_func(M, N)).append('\n');
        }
        System.out.print(sb.toString());
    }
}
