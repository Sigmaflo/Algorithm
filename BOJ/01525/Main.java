import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[3][3];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static int[][] board;
    static int ans;
    static int[][] dir = {{0 ,1}, {0 ,-1}, {1 ,0}, {-1 ,0}};
    static Map<Integer, Integer> map = new HashMap<>();

    static int[][] swap(int x1, int y1, int x2, int y2, int[][] board) {
        int tmp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = tmp;
        return board;
    }

    static int getNum(int[][] arr) {
        int num = 0;
        int n = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                num += arr[i][j] * (int)Math.pow(10, n);
                n++;
            }
        }
        return num;
    }

    static class Dot {
        int x, y, move;
        int[][] myboard;

        public Dot(int x, int y, int move, int[][] _myboard) {
            this.x = x;
            this.y = y;
            this.move = move;
            myboard = new int[3][];
            for (int i = 0; i < 3; i++) {
                myboard[i] = _myboard[i].clone();
            }
        }
    }

    static int[][] deepClone(int[][] arr) {
        int[][] temp = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            temp[i] = arr[i].clone();
        }
        return temp;
    }

    static void bfs(int sx, int sy, int smove) {
        Queue<Dot> Q = new LinkedList<>();
        Q.add(new Dot(sx, sy, smove, board));
        map.put(getNum(board), 0);
        while(!Q.isEmpty()) {
            Dot dot = Q.poll();
            if (getNum(dot.myboard) == 987654321) {
                ans = dot.move;
                return;
            }
            for (int k = 0; k < 4; k++) {
                int nx = dot.x + dir[k][0], ny = dot.y + dir[k][1];
                int[][] temp = deepClone(dot.myboard);
                if (nx < 0 || ny < 0 || nx >= 3 || ny >= 3) continue;
                temp = swap(dot.x, dot.y, nx, ny, temp);
                if (map.containsKey(getNum(temp))) continue;
                map.put(getNum(temp), dot.move + 1);
                Q.add(new Dot(nx, ny, dot.move + 1, temp));
            }
        }
        ans = -1;
    }

    static void pro() {
        int sx = 0, sy = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j] == 0) {
                    sx = i;
                    sy= j;
                    board[i][j] = 9;
                }
            }
        }

        ans = Integer.MAX_VALUE;
        bfs(sx, sy, 0);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
