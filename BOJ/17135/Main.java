import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, D, K, ans;
    static int[][] board;
    static int[] archer;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}};
    static int[][] target;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        archer = new int[M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void bfs(int j, int[][] A) {
        boolean[][] visit = new boolean[N][M];
        Queue<Integer> Q = new LinkedList<>();
        Q.add(N);
        Q.add(j);
        Q.add(0);
        while (!Q.isEmpty()) {
            int x = Q.poll(), y = Q.poll(), move = Q.poll();
            if (move == D) continue;
            for (int k = 0; k < 3; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visit[nx][ny]) continue;
                if (A[nx][ny] == 1) {
                    target[K][0] = nx;
                    target[K][1] = ny;
                    K++;
                    return;
                }
                visit[nx][ny] = true;
                Q.add(nx);
                Q.add(ny);
                Q.add(move + 1);
            }
        }
    }

    static void calculation(int[][] A) {
        int kill = 0;
        for (int i = 0; i < N; i++) {
            K = 0;
            target = new int[3][2];
            for (int j = 0; j < M; j++) {
                if (archer[j] == 1) {
                    bfs(j, A);
                }
            }
            for (int k = 0; k < K; k++) {
                if (A[target[k][0]][target[k][1]] == 1) {
                    A[target[k][0]][target[k][1]] = 0;
                    kill++;
                }
            }
            int[] front = new int[M];
            Arrays.fill(front, 0);
            int[] tmp = A[1];
            for (int x = N - 2; x >= 0; x--) {
                for (int y = 0; y < M; y++) {
                    A[x + 1][y] = A[x][y];
                }
            }
            A[0] = front;
        }
        ans = Math.max(ans, kill);
    }

    static void rec_func(int k, int cnt) {
        if (cnt == 3) {
            int[][] _A = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    _A[i][j] = board[i][j];
                }
            }
            calculation(_A);
            return;
        }
        if (k == M) return;

        archer[k] = 1;
        rec_func(k + 1, cnt + 1);

        archer[k] = 0;
        rec_func(k + 1, cnt);

    }

    static void pro() {
        ans = 0;
        rec_func(0 , 0);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
