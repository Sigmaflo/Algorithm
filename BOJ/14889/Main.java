import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, ans;
    static int[][] S;
    static boolean[] select;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N + 1][N + 1];
        select = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static int calculate(int[] arr) {
        int sum = 0;
        for (int i  = 0; i < arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++){
                sum += S[arr[i]][arr[j]];
                sum += S[arr[j]][arr[i]];
            }
        }
        return sum;
    }

    static void rec_func(int k, int cnt) {
        if (cnt == N / 2) {
            int[] team1 = new int[N/2];
            int[] team2 = new int[N/2];
            int idx1 = 0;
            int idx2 = 0;
            for (int i = 1; i <= N; i++) {
                if(select[i]) {
                    team1[idx1] = i;
                    idx1++;
                } else {
                    team2[idx2] = i;
                    idx2++;
                }
            }
            int s1 = calculate(team1);
            int s2 = calculate(team2);
            ans = Math.min(ans, Math.abs(s1 -s2));
            return;
        }
        if (k == N + 1) return;
        select[k] = true;
        rec_func(k + 1, cnt + 1);
        select[k] = false;
        rec_func(k + 1, cnt);
    }

    static void pro() {
        ans = Integer.MAX_VALUE;
        rec_func(1, 0);
        System.out.println(ans);

    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
