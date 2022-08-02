import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            int[][] farm = new int[N][N];
            for(int i = 0; i < N; i++){
                String row = br.readLine();
                for(int j = 0; j < N; j++){
                    farm[i][j] = Integer.parseInt(row.charAt(j)+"");
                }
            }
//            int d = N / 2;
            int[] d = new int[N];
            for(int i = 0; i < N/2; i++){
                d[i] = N/2 - i;
            }
            int u = 0;
            for(int i = N/2; i < N; i++){
                d[i] = u;
                u++;
            }
            int sum = 0;
            for(int i = 0; i < N; i++){
                int a = d[i];
                int b = N-d[i];
                for(int j = a; j < b; j++){
                    sum += farm[i][j];
                }
            }
            System.out.printf("#%d %d\n", t, sum);
        }
    }
}
