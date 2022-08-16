import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int sx, sy;
    static int[][] result;
    static int[][] dist;
    static boolean[][] visit;
    static int[][] dir = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N + 1][N + 1];
        dist = new int[N + 1][N + 1];
        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
        result = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            result[i][0] = Integer.parseInt(st.nextToken());
            result[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    static void bfs(int sx, int sy) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(sx);
        Q.add(sy);
        visit[sx][sy] = true;
        while(!Q.isEmpty()) {
            int x = Q.poll(), y = Q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = x + dir[i][0], ny = y + dir[i][1];
                if (nx < 1 || ny < 1 || nx > N || ny > N) continue;
                if (visit[nx][ny]) continue;
                visit[nx][ny] = true;
                dist[nx][ny] = dist[x][y] + 1;
                Q.add(nx);
                Q.add(ny);
            }
        }
    }

    static void pro() {
        bfs(sx, sy);
        for (int i = 0; i < M; i++) {
            System.out.print(dist[result[i][0]][result[i][1]] + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
