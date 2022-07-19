import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static char[][] board;
    static boolean[][] visit;
    static int[] nx = {1, -1, 0 ,0};
    static int[] ny = {0, 0, 1, -1};

    public static void search(int sx, int sy){
        char color = board[sx][sy];
        visit[sx][sy] = true;
        for(int k = 0; k < 4; k++){
            int x = sx + nx[k];
            int y = sy + ny[k];
            if(x >= 0 && x < N && y >= 0 && y < N){
                if(!visit[x][y] && board[x][y] == color){
                    search(x, y);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        visit = new boolean[N][N];
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int k = 0; k < line.length(); k++){
                board[i][k] = line.charAt(k);
                visit[i][k] = false;
            }
        }
        int count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visit[i][j]){
                    search(i, j);
                    count++;
                }
            }
        }
        System.out.print(count+" ");
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(board[i][j] == 'G'){
                    board[i][j] = 'R';
                }
                visit[i][j] = false;
            }
        }
        count = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visit[i][j]){
                    search(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
