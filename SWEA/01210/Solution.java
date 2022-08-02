import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[][] board;
    static int checkRL(int x, int y){
        if(y - 1 >= 0 && board[x][y-1] == 1) {
            return -1;
        }else if(y + 1 < board.length && board[x][y+1] == 1){
            return 1;
        }else{
            return 0;
        }
    }

    static int checkDown(int x, int y){
        if(x + 1 < board.length && board[x+1][y] == 1){
            return 1;
        }else{
            return 0;
        }
    }

    static int ladder(){
        int answer = -1;
        for(int i = 0; i < board.length; i++){
            if(board[0][i] == 1){
                boolean end = false;
                int curState = 1; //1:down, -1:right or left
                int x = 0;
                int y = i;
                while(!end){
                    if(curState == 1){
                        x += 1;
                        while(checkRL(x, y) == 0){
                            if(x == board.length-1){
                                end = true;
                                if(board[x][y] == 2){
                                    answer = i;
                                }
                                break;
                            }else{
                                x += 1;
                            }
                        }
                        curState = -1;
                    }else if(curState == -1){
                        int ny = checkRL(x, y);
                        y += ny;
                        while(checkDown(x, y) == 0){
                            y += ny;
                        }
                        curState = 1;
                    }
                }
                if(answer != -1){
                    return answer;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 1; t <= 10; t++){
            int T = Integer.parseInt(br.readLine());
            board = new int[100][100];
            for(int i = 0; i < 100; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int answer = ladder();
            System.out.printf("#%d %d\n", T, answer);
        }
    }
}
