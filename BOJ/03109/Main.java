import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, ans;
    static char[][] board;
    static boolean[][] visit;
    static int[][] dir = {{-1, 1}, {0, 1}, {1, 1}};
    static boolean found;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }
    }

    static void dfs(int x, int y) {
        visit[x][y] = true;
        if (y == C - 1) {
            ans++;
            found = true;
            return;
        }
        for (int k = 0; k < 3; k++) {
            int nx = x + dir[k][0], ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if (visit[nx][ny]) continue;
            if (board[nx][ny] == 'x') continue;
            visit[nx][ny] = true;
            dfs(nx, ny);
            if (found) return;
        }
    }

    static void pro() {
        visit = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            found = false;
            dfs(i, 0);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
