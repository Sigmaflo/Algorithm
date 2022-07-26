import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] board = new char[20][20]; // 오목판
    static int[] nx = {-1, 0, 1, 1};
    static int[] ny = {1, 1, 0, 1};

    public static boolean search(int x, int y) {
        char stone = board[x][y];
        for (int i = 0; i < 4; i++) {//4방향 탐색
            int sequence = 1;
            int prev_x = x + nx[i]*-1;
            int prev_y = y + ny[i]*-1;
            boolean isSearched = false;
            if (prev_x > 0 && prev_x < 20 && prev_y > 0 && prev_y < 20) {
                if(board[prev_x][prev_y] == stone){//탐색할 스톤의 반대편이 같은 돌일때(지나간 자리)
                    isSearched = true;
                }
            }
            if(!isSearched){
                for (int j = 1; j <= 4; j++) {//한쪽 방향으로 4번 탐색
                    int next_x = x + nx[i] * j;
                    int next_y = y + ny[i] * j;
                    if (next_x > 0 && next_x < 20 && next_y > 0 && next_y < 20) {
                        if (board[next_x][next_y] == stone) {//만약 연속이면
                            sequence++;//연속된 돌 개수 추가
                        }
                    }
                }
                if (sequence == 5) {//5개 연속일 때
                    int next_x = x + nx[i] * 5;
                    int next_y = y + ny[i] * 5;
                    if (next_x > 0 && next_x < 20 && next_y > 0 && next_y< 20) {
                        if(board[next_x][next_y] == stone){//6개 연속이면
                            return false;
                        }
                    }

                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 19; i++) {// 오목판 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 19; j++) {
                board[i][j] = st.nextToken().charAt(0);
            }
        }
        boolean find = false;
        for (int i = 1; i <= 19; i++) {// 오목판 입력
            for (int j = 1; j <= 19; j++) {
                if (board[i][j] == '1' || board[i][j] == '2') {
                    find = search(i, j);
                    if (find) {
                        System.out.println(board[i][j]);
                        System.out.println(i + " " + j);
                        break;
                    }
                }
            }
            if (find) {
                break;
            }
        }
        if (!find){
            System.out.println(0);
        }
    }
}