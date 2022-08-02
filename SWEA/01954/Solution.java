import java.util.Scanner;

public class Solution {
    static boolean[][] visit;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for(int t = 1; t <= T; t++){
            int N = scan.nextInt();
            int[][] board = new int[N][N];
            visit = new boolean[N][N];
            int line = 0;
            int x = 0;
            int y = 0;
            board[0][0] = 1;
            visit[0][0] = true;
            int step = 2;
            while(true){
                if(line == 0){
                    if(y+1 < board.length && !visit[x][y+1]){
                        board[x][y+1] = step;
                        step++;
                        y++;
                        visit[x][y] = true;
                    }else{
                        line++;
                    }
                }else if(line == 1){
                    if(x+1 < board.length && !visit[x+1][y]){
                        board[x+1][y] = step;
                        step++;
                        x++;
                        visit[x][y] = true;
                    }else{
                        line++;
                    }
                }else if(line == 2){
                    if(y-1 >= 0 && !visit[x][y-1]){
                        board[x][y-1] = step;
                        step++;
                        y--;
                        visit[x][y] = true;
                    }else{
                        line++;
                    }
                }else if(line == 3){
                    if(x-1 >= 0 && !visit[x-1][y]){
                        board[x-1][y] = step;
                        step++;
                        x--;
                        visit[x][y] = true;
                    }else{
                        line = 0;
                    }
                }
                if(step == N * N + 1){
                    break;
                }
            }
            System.out.printf("#%d\n",t);
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board.length; j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println("");
            }
        }
    }
}
