import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, ans;
    static int[][] A;
    static boolean[] select;
    static int[] result;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1][10];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k = 1; k <= 9; k++) A[i][k] = Integer.parseInt(st.nextToken());
        }
    }

    static void gameStart(int[] hitter) {
        int point = 0;
        int num = 1;
        int out = 0;
        int[] base = new int[5];
        for (int n = 1; n <= N; n++) {
            while(true) {
                if (A[n][hitter[num]] == 0){
                    out++;
                } else {
                    base[0] = 1;
                    for (int i = 0; i < A[n][hitter[num]]; i++) {
                        for (int k = 4; k > 0; k--) {
                            base[k] = base[k-1];
                            base[k-1] = 0;
                        }
                        if(base[4] == 1) point++;
                        base[4] = 0;
                    }
                }
                num++;
                if (num == 10) num = 1;
                if (out == 3) break;

            }
            Arrays.fill(base, 0);
            out = 0;
        }
        ans = Math.max(ans, point);
    }

    static void rec_func(int k) {
        if (k == 8) {
            int[] hitter = new int[10];
            hitter[4] = 1;
            int s = 0;
            for (int d = 1; d <= 3; d++) {
                hitter[d] = result[s];
                s++;
            }
            for (int d = 5; d <= 9; d++) {
                hitter[d] = result[s];
                s++;
            }
            gameStart(hitter);
            return;
        }
        for (int i = 2; i <= 9; i++) {
            if(select[i]) continue;
            select[i] = true;
            result[k] = i;
            rec_func(k + 1);
            select[i] = false;
        }
    }

    static void pro() {
        select = new boolean[10];
        result = new int[10];
        rec_func(0);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
