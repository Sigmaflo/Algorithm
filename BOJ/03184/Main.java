import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C, sheep, wolf;
    static char[][] board;
    static boolean[][] visit;
    static int[][] dir = {{0 ,1}, {0 ,-1}, {1 ,0}, {-1 ,0}};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][];
        visit = new boolean[R][C];
        for (int i = 0 ; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }
    }

    static void bfs(int sx, int sy) {
        Queue<Integer> Q = new LinkedList<>();
        int s = 0, w = 0;
        Q.add(sx);
        Q.add(sy);
        visit[sx][sy] = true;
        while(!Q.isEmpty()) {
            int x = Q.poll(), y = Q.poll();
            if (board[x][y] == 'o') s++;
            if (board[x][y] == 'v') w++;
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (visit[nx][ny]) continue;
                if (board[nx][ny] == '#') continue;
                visit[nx][ny] = true;
                Q.add(nx);
                Q.add(ny);
            }
        }
        if (s == 0) {
            wolf += w;
        } else if (w == 0) {
            sheep += s;
        } else if (s > w) {
            sheep += s;
        } else {
            wolf += w;
        }
    }

    static void pro() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == '#' || visit[i][j]) continue;
                bfs(i , j);
            }
        }
        System.out.println(sheep + " " + wolf);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
