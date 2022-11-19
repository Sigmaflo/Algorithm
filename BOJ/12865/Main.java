import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[][] product, memo;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        product = new int[n+1][2];
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            product[i][0] = Integer.parseInt(st.nextToken());
            product[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        memo = new int[n+1][k+1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < k + 1; j++) {
                memo[i][j] = memo[i-1][j];
                if (j - product[i][0] >= 0) {
                    memo[i][j] = Math.max(memo[i][j],memo[i-1][j-product[i][0]] + product[i][1]);
                }
            }
//            print(memo);
        }
        System.out.println(memo[n][k]);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }

    static void print(int[][] arr) {
        System.out.println("---------------------------");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] < 10) System.out.print(0);
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
