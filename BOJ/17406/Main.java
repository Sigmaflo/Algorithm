import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int N, M, K, ans;
    static int[][] op;
    static boolean[] select;
    static int[] result;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        op = new int[K][];
        result = new int[K];
        select = new boolean[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            op[i] = new int[]{Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())};
        }
    }

    static void set_min() {
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += arr[i][j];
            }
            ans = Math.min(ans, sum);
        }
    }

    static void rotate(int[] operation) {
        for (int o: operation) {
            int ax = op[o][0] - op[o][2], ay = op[o][1] - op[o][2],
            bx = op[o][0] + op[o][2], by = op[o][1] + op[o][2];
            int depth = Math.min(bx - ax + 1, by - ay + 1) / 2;

            for (int d = 0; d < depth; d++) {
                int temp = arr[ax+d][ay+d];

                for (int x = ax + d; x < bx - d; x++) arr[x][ay+d] = arr[x+1][ay+d];
                for (int y = ay + d; y < by - d; y++) arr[bx-d][y] = arr[bx-d][y+1];
                for (int x = bx - d; x > ax + d; x--) arr[x][by-d] = arr[x-1][by-d];
                for (int y = by - d; y > ay + d; y--) arr[ax+d][y] = arr[ax+d][y-1];
                arr[ax+d][ay+d+1] = temp;
             }
        }
        set_min();
    }

    static void rec_func(int k) {
        if (k == K) {
            int[][] temp = new int[N][];
            for (int i = 0; i < N; i++){
                temp[i] = arr[i].clone();
            }
            rotate(result);
            arr = temp;
            return;
        }
        for (int i = 0; i < K; i++) {
            if(select[i]) continue;
            select[i] = true;
            result[k] = i;
            rec_func(k + 1);
            select[i] = false;
        }
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
