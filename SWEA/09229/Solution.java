import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input() throws IOException {
        selected = new int[3];
        ans = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        snack = new Integer[N];
        used = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            snack[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(snack, Collections.reverseOrder());
    }

    static void pro(){
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                sum = snack[i] + snack[j];
                if(sum <= M){
                    ans = Math.max(ans, sum);
                }
            }
        }

    }

    static int N, M, ans;
    static Integer[] snack;
    static boolean[] used;
    static int[] selected;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            input();
            pro();
            System.out.printf("#%d %d\n", t, ans);
        }
    }
}