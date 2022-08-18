import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, ans;
    static char[][] board;
    static boolean[] alpha;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            board[i] = line.toCharArray();
        }
    }


    static void dfs (int x, int y, int move) {
        alpha[board[x][y] - 'A'] = true;
        ans = Math.max(ans, move);
        for (int k = 0; k < 4; k++) {
            int nx = x + dir[k][0], ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if (alpha[board[nx][ny] - 'A']) continue;
            dfs(nx, ny, move + 1);
            alpha[board[nx][ny] - 'A'] = false;
        }
    }

    static void pro() {
        alpha = new boolean[26];
        dfs(0, 0, 1);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
