import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, ans;
    static int[][] ingredient;
    static boolean[] select;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ingredient = new int[N][2];
        select = new boolean[N];
        for (int i = 0;  i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ingredient[i][0] = Integer.parseInt(st.nextToken());
            ingredient[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    static void calculation(List<Integer> list) {
        int sum1 = 1;
        int sum2 = 0;
        for(int n: list) {
            sum1 *= ingredient[n][0];
            sum2 += ingredient[n][1];
        }
        ans = Math.min(ans, Math.abs(sum1 - sum2));
    }

    static void rec_func(int k) {
        if (k == N) {
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                if(select[i]) list.add(i);
            }
            if(list.size() > 0) calculation(list);
            return;
        }
        select[k] = true;
        rec_func(k + 1);
        select[k] = false;
        rec_func(k + 1);
    }

    static void pro() {
        ans = Integer.MAX_VALUE;
        rec_func(0);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
