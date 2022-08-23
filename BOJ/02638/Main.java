import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, ans;
    static int[][] A;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    static LinkedList<Cheese> cheeses;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void bfs_findBlank() {
        Queue<Integer> Q = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];
        for (int j = 0; j < M; j++) {
            if(A[0][j] != 1) {
                Q.add(0);
                Q.add(j);
                A[0][j] = 2;
                visit[0][j] = true;
            }
        }
        for (int j = 0; j < M; j++) {
            if(A[N-1][j] != 1) {
                Q.add(N-1);
                Q.add(j);
                A[N-1][j] = 2;
                visit[N-1][j] = true;
            }
        }
        for (int i = 0; i < N; i++) {
            if(A[i][0] != 1) {
                Q.add(i);
                Q.add(0);
                A[i][0] = 2;
                visit[i][0] = true;
            }
        }
        for (int i = 0; i < N; i++) {
            if(A[i][M-1] != 1) {
                Q.add(i);
                Q.add(M-1);
                A[i][M-1] = 2;
                visit[i][M-1] = true;
            }
        }
        while (!Q.isEmpty()) {
            int x = Q.poll(), y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if (visit[nx][ny]) continue;
                if (A[nx][ny] == 1) continue;
                visit[nx][ny] = true;
                A[nx][ny] = 2;
                Q.add(nx);
                Q.add(ny);
            }
        }
    }

    static class Cheese {
        int x, y;
        int count;

        public Cheese(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void melt_cheese() {
        for (int i = 0; i < cheeses.size(); i++) {
            Cheese cheese = cheeses.get(i);
            cheese.count = 0;
            for (int k = 0; k < 4; k++) {
                int fx = cheese.x + dir[k][0], fy = cheese.y + dir[k][1];
                if (fx < 0 || fy < 0 || fx >= N || fy >= M) continue;
                if (A[fx][fy] != 2) continue;
                cheese.count++;
            }
            if (cheese.count >= 2) {
                A[cheese.x][cheese.y] = 0;
                cheeses.remove(i);
                i--;
            }
        }
    }

    static void pro() {
        cheeses = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(A[i][j] == 1) cheeses.add(new Cheese(i, j));
            }
        }
        while(!cheeses.isEmpty()) {
            // 외부 공간 찾기
            bfs_findBlank();
            // 녹일 치즈 찾기 및 치즈 녹이기
            melt_cheese();
            ans++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}

