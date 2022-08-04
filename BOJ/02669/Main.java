import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[101][101];
        for(int k = 0; k < 4; k++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            for(int i = a; i < c; i++){
                for(int j = b; j < d; j++){
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
