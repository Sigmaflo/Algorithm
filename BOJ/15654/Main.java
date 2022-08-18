import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] nums;
    static boolean[] select;
    static int[] result;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        select = new boolean[N];
        result = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void rec_func(int k, int cnt) {
        if (cnt == M) {
            for (int n : result) {
                sb.append(n).append(" ");
            }
            sb.append('\n');
            return;
        }
        if (k >= N) return;
        for (int i = 0; i < N; i++) {
            if (select[i]) continue;
            select[i] = true;
            result[k] = nums[i];
            rec_func(k + 1, cnt + 1);
            select[i] = false;
        }
    }

    static void pro() {
        Arrays.sort(nums);
        rec_func(0, 0);
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
