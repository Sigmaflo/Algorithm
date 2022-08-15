import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int k;
    static int[] S;
    static boolean[] select;

    static boolean input() throws IOException {
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        if (k == 0) return false;
        S = new int[k];
        select = new boolean[k];
        for (int i = 0; i < k; i++) S[i] = Integer.parseInt(st.nextToken());
        return true;
    }

    static void rec_func(int idx, int cnt) {
        if (cnt == 6) {
            for (int i = 0; i < k; i++) {
                if (select[i]) {
                    sb.append(S[i]).append(" ");
                }
            }
            sb.append('\n');
            return;
        }
        if (idx == k) return;
        select[idx] = true;
        rec_func(idx + 1, cnt + 1);
        select[idx] = false;
        rec_func(idx + 1, cnt);
    }

    public static void main(String[] args) throws IOException {
        boolean con = input();
        while(con) {
            rec_func(0, 0);
            sb.append('\n');
            System.out.print(sb.toString());
            con = input();
        }
    }
}
