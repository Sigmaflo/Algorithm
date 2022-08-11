import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        food = new int[N][2];
        select = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            food[i][0] = Integer.parseInt(st.nextToken()); // 점수
            food[i][1] = Integer.parseInt(st.nextToken()); // 칼로리
        }
        ans = 0;
    }

    static int N, L, ans;
    static int[][] food;
    static boolean[] select;

    static void rec_func(int k, int faver, int calorie) {
        if (k == food.length) {
            ans = Math.max(ans, faver);
            return;
        }
        if(calorie + food[k][1] <= L) {
            select[k] = true;
            rec_func(k + 1, faver + food[k][0], calorie + food[k][1]);
        }
        select[k] = false;
        rec_func(k + 1, faver, calorie);
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            input();
            rec_func(0 , 0, 0);
            System.out.printf("#%d %d\n", t, ans);
        }
    }
}
