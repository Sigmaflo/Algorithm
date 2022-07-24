import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[101][101];
        int n = Integer.parseInt(br.readLine());
        for(int t = 0; t < n; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int i = x; i < x + 10; i++){
                for(int j = y; j < y + 10; j++){
                    board[i][j] = 1;
                }
            }
        }
        int length = 0;
        int nx[] = {0, 0, -1, 1};
        int ny[] = {-1, 1, 0, 0};
        for(int i = 1; i <= 100; i++){
            for(int j = 1; j <= 100; j++){
                if(board[i][j] == 1){
                    for(int k = 0; k < 4; k++){
                        int x = i + nx[k];
                        int y = j + ny[k];
                        if(board[x][y] == 0){
                            length++;
                        }
                    }
                }
            }
        }
        System.out.println(length);
    }
}
