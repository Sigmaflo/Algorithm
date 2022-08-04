import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int[][] board = new int[101][101];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int t = 0; t < n; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for(int i = a; i < a + 10; i++){
                for(int j = b; j < b + 10; j++){
                    board[i][j] = 1;
                }
            }
        }
        int sum = 0;
        for(int i = 0; i < 101; i++){
            for(int j = 0; j < 101; j++){
                if(board[i][j] == 1){
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}
