import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int[][] op;
    static int N;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        op = new int[N][2];
        for (int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            op[i][0] = Integer.parseInt(st.nextToken());
            op[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(op, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
    }

    static void pro() {
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += (long)op[i-1][0] * i + (long)op[i-1][1];
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
