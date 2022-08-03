import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static char[] tank_state = {'^', 'v', '<', '>'};
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};
    static int H;
    static int W;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            board = new char[H][W];
            for(int i = 0; i < H; i++){
                String line = br.readLine();
                board[i] = line.toCharArray();
            }
            int N = Integer.parseInt(br.readLine());
            char[] cmds = br.readLine().toCharArray();
            //input end
            int tank_i = 0;
            int tank_j = 0;
            char curState = ' ';
            for(int i = 0; i < H; i++){
                for(int j = 0; j < W; j++){
                    for(int k = 0; k < 4; k++){
                        if(board[i][j] == tank_state[k]){
                            tank_i = i;
                            tank_j = j;
                            curState = tank_state[k];
                            break;
                        }
                    }
                }
            }
            int no, next_tank_i, next_tank_j;
            for(char cmd: cmds){
//                System.out.println("cmd: "+cmd);
                switch (cmd){
                    case 'U':
                        no = 0;
                        board[tank_i][tank_j] = tank_state[no];
                        curState = board[tank_i][tank_j];
                        next_tank_i = tank_i + di[no];
                        next_tank_j = tank_j + dj[no];
                        if(canMove(next_tank_i, next_tank_j)){
                            board[tank_i][tank_j] = '.';
                            tank_i = next_tank_i;
                            tank_j = next_tank_j;
                            board[tank_i][tank_j] = tank_state[no];
                        }
                        break;
                    case 'D':
                        no = 1;
                        board[tank_i][tank_j] = tank_state[no];
                        curState = board[tank_i][tank_j];
                        next_tank_i = tank_i + di[no];
                        next_tank_j = tank_j + dj[no];
                        if(canMove(next_tank_i, next_tank_j)){
                            board[tank_i][tank_j] = '.';
                            tank_i = next_tank_i;
                            tank_j = next_tank_j;
                            board[tank_i][tank_j] = tank_state[no];
                        }
                        break;
                    case 'L':
                        no = 2;
                        board[tank_i][tank_j] = tank_state[no];
                        curState = board[tank_i][tank_j];
                        next_tank_i = tank_i + di[no];
                        next_tank_j = tank_j + dj[no];
                        if(canMove(next_tank_i, next_tank_j)){
                            board[tank_i][tank_j] = '.';
                            tank_i = next_tank_i;
                            tank_j = next_tank_j;
                            board[tank_i][tank_j] = tank_state[no];
                            curState = tank_state[no];
                        }
                        break;
                    case 'R':
                        no = 3;
                        board[tank_i][tank_j] = tank_state[no];
                        curState = board[tank_i][tank_j];
                        next_tank_i = tank_i + di[no];
                        next_tank_j = tank_j + dj[no];
                        if(canMove(next_tank_i, next_tank_j)){
                            board[tank_i][tank_j] = '.';
                            tank_i = next_tank_i;
                            tank_j = next_tank_j;
                            board[tank_i][tank_j] = tank_state[no];
                            curState = tank_state[no];
                        }
                        break;
                    case 'S':
                        for(int k = 0; k < 4; k++){
                            if(curState == tank_state[k]){
                                for(int n = 1; n <= 20; n++){
                                    int next_i = tank_i + di[k] * n;
                                    int next_j = tank_j + dj[k] * n;
                                    if(!(next_i >= 0 && next_i < H && next_j >=0 && next_j < W)){
                                        break;
                                    }else if(board[next_i][next_j] == '*'){
                                        board[next_i][next_j] = '.';
                                        break;
                                    }else if(board[next_i][next_j] == '#'){
                                        break;
                                    }
                                }
                            }
                        }
                        break;
                }
//                print();
            }
            System.out.printf("#%d ",t);
            print();
        }
    }

    static boolean canMove(int i, int j){
        if(i >= 0 && j >= 0 && i < H && j < W && board[i][j] == '.') {
            return true;
        }
        return false;
    }

    static void print(){
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
    }
}
