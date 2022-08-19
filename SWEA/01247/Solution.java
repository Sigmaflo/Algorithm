import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] A;
    static int N, ans;
    static int[] result;
    static boolean[] select;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N + 2][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N + 2; i++) {
            A[i][0] = Integer.parseInt(st.nextToken());
            A[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    static int calculation(int[] list) {
        int sum = 0;
        int sx = A[0][0], sy = A[0][1], ex = A[1][0], ey = A[1][1];
        for (int i = 0; i < list.length; i++) {
            int x = A[list[i]][0], y = A[list[i]][1];
            sum += Math.abs(sx - x) + Math.abs(sy - y);
            sx = x;
            sy = y;
        }
        sum += Math.abs(sx - ex) + Math.abs(sy - ey);
        return sum;
    }

    static void rec_func(int k) {
        if (k == N + 2) {
            int sum = calculation(result);
            ans = Math.min(ans, sum);
            return;
        }
        for (int i = 2; i < N + 2; i++) {
            if(select[i]) continue;
            result[k] = i;
            select[i] = true;
            rec_func(k + 1);
            select[i] = false;
        }
    }

    static void pro() {
        result = new int[N + 2];
        select = new boolean[N + 2];
        ans = Integer.MAX_VALUE;
        rec_func(2);
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            input();
            pro();
            System.out.printf("#%d %d\n", tt, ans);
        }
    }
}
