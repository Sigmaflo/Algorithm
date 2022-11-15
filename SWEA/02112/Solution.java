import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int d, w, k, ans;
    static int[][] A;
    static int[] C;

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        A = new int[d][w];
        for (int i = 0; i < d; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static boolean valid(int j, int[] C) {
        int seq = 1, prev = A[0][j];
        if (C[0] != -1) prev = C[0];

        for (int i = 1; i < d; i++) {
            if (C[i] != -1) {
                if (C[i] == prev) {
                    seq++;
                } else {
                    prev = C[i];
                    seq = 1;
                }
            } else if (A[i][j] == prev) {
                seq++;
            } else {
                prev = A[i][j];
                seq = 1;
            }
            if (seq >= k) return true;
        }

        return false;
    }

    static boolean allValid(int[] C) {
        for (int j = 0; j < w; j++) {
            if (!valid(j, C)) {
                return false;
            }
        }
        return true;
    }

    static void rec_func(int k, int select) {
        if (k == d) {
            if (allValid(C)) {
                ans = Math.min(ans, select);
            }
            return;
        }
        C[k] = -1;
        rec_func(k + 1, select);
        C[k] = 0;
        rec_func(k + 1, select + 1);
        C[k] = 1;
        rec_func(k + 1, select + 1);
    }

    static void pro() {
        ans = Integer.MAX_VALUE;
        C = new int[d];
        Arrays.fill(C, -1);
        rec_func(0, 0);
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            input();
            pro();
            sb.append("#").append(tc).append(" ").append(ans).append('\n');
        }
        System.out.println(sb.toString());
    }
}
