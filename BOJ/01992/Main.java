import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[][] board;
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }
    }

    static boolean isAllSame(int x, int y, int n) {
        int c = board[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (board[i][j] != c) return false;
            }
        }
        return true;
    }

    static void rec_func(int x, int y, int n) {
        if (n >= 4 && isAllSame(x, y, n)) {
            sb.append(board[x][y]);
            return;
        } else if (n == 2) {
            if (isAllSame(x, y, n)) {
                sb.append(board[x][y]);
            } else {
                sb.append('(');
                sb.append(board[x][y]);
                sb.append(board[x][y+1]);
                sb.append(board[x+1][y]);
                sb.append(board[x+1][y+1]);
                sb.append(')');
            }
            return;
        }
        sb.append('(');
        n = n / 2;
        rec_func(x, y, n);
        rec_func(x, y + n, n);
        rec_func(x + n, y, n);
        rec_func(x + n, y + n, n);
        sb.append(')');
    }

    static void pro() {
        rec_func(0, 0, N);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
