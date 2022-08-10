import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans_num = board[0][0]; ans_count = 1;
    }

    static int N;
    static int ans_num, ans_count;
    static int[][] board;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    static int bfs(int x, int y) {
        boolean[][] visit = new boolean[N][N];
        int count = 1;
        Queue<Integer> Q = new LinkedList<>();
        visit[x][y] = true;
        Q.add(x);
        Q.add(y);
        while(!Q.isEmpty()) {
            x = Q.poll(); y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visit[nx][ny]) continue;
                if (board[nx][ny] - board[x][y] != 1) continue;
                visit[nx][ny] = true;
                count++;
                Q.add(nx);
                Q.add(ny);
            }
        }
        return count;
    }

    static void pro() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int a =  board[i][j];
                int count = bfs(i, j);
                if(count == ans_count) {
                    ans_num = Math.min(ans_num, board[i][j]);
                } else if (count > ans_count) {
                    ans_num = board[i][j];
                    ans_count = count;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            input();
            pro();
            System.out.printf("#%d %d %d\n", t, ans_num, ans_count);
        }
    }
}
