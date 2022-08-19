import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, ans;
    static int[][] board;
    static List<Dot> put_list, white_list;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean[] select;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static class Dot {
        int x, y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int calculation(Dot[] dots) {
        int sum = 0;
        boolean[][] white_visit = new boolean[N][M];
        for (Dot white: white_list) {
            if (white_visit[white.x][white.y]) continue;
            white_visit[white.x][white.y] = true;
            int temp = 1;
            Queue<Dot> Q = new LinkedList<>();
            Q.add(white);
            boolean avabile = true;
            while(!Q.isEmpty()) {
                Dot w = Q.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = w.x + dir[k][0], ny = w.y + dir[k][1];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if (white_visit[nx][ny]) continue;
                    if (board[nx][ny] == 1) continue;
                    if (nx == dots[0].x && ny == dots[0].y) continue;
                    if (nx == dots[1].x && ny == dots[1].y) continue;
                    if (board[nx][ny] == 0) {
                        avabile = false;
                    }
                    white_visit[nx][ny] = true;
                    temp++;
                    Q.add(new Dot(nx, ny));
                }
            }
            if(avabile) sum += temp;
        }
        return sum;
    }

    static void rec_func(int k, int cnt) {
        if (cnt == 2) {
            Dot[] result = new Dot[2];
            int d = 0;
            for (int i = 0; i < select.length; i++) {
                if (select[i]) {
                    result[d] = put_list.get(i);
                    d++;
                }
            }
            ans = Math.max(ans, calculation(result));
            return;
        }
        if (k == select.length) return;
        select[k] = true;
        rec_func(k + 1, cnt + 1);
        select[k] = false;
        rec_func(k + 1, cnt);
    }

    static void pro() {
        put_list = new ArrayList<>();
        white_list = new ArrayList<>();
        boolean[][] visit = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j]) continue;
                if (board[i][j] != 2) continue;
                white_list.add(new Dot(i, j));
                for (int k = 0; k < 4; k++) {
                    int nx = i + dir[k][0], ny = j + dir[k][1];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if (visit[nx][ny]) continue;
                    if (board[nx][ny] != 0) continue;
                    visit[nx][ny] = true;
                    put_list.add(new Dot(nx, ny));
                }
            }
        }
        select = new boolean[put_list.size()];
        ans = 0;
        if (put_list.size() == 1) {
            Dot[] dots = new Dot[2];
            dots[0] = put_list.get(0);
            dots[1] = new Dot(-1, -1);
            ans = calculation(dots);
        } else {
            rec_func(0, 0);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
