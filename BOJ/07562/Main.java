import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int I;
    static int sx, sy, ex, ey, ans;
    static boolean[][] visit;
    static int[][] dir = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}};

    static void input() throws IOException {
        ans = 0;
        I = Integer.parseInt(br.readLine());
        visit = new boolean[I][I];
        StringTokenizer st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ex = Integer.parseInt(st.nextToken());
        ey = Integer.parseInt(st.nextToken());
    }

    static void bfs(int sx, int sy) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(sx);
        Q.add(sy);
        Q.add(0);
        visit[sx][sy] = true;
        while(!Q.isEmpty()) {
            int x = Q.poll(), y = Q.poll(), move = Q.poll();
            if(x == ex && y == ey) {
                ans = move;
                Q.clear();
                continue;
            }
            for (int k = 0; k < 8; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= I || ny >= I) continue;
                if (visit[nx][ny]) continue;
                visit[nx][ny] = true;
                Q.add(nx);
                Q.add(ny);
                Q.add(move + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            input();
            bfs(sx, sy);
            System.out.println(ans);
        }
    }
}
