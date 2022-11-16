import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, ans;
    static int[][] A;
    static int[][] point;
    static boolean[][] visited;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        A = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        point = new int[2][2];
        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    static void bfs(int sx, int sy) {
        visited = new boolean[n][n];
        Queue<Integer> Q = new LinkedList<>();
        Q.add(sx);
        Q.add(sy);
        visited[sx][sy] = true;
        int time = 0;
        while(!Q.isEmpty()) {
            int size = Q.size() / 2;
            for (int s = 0; s < size; s++) {
                int x = Q.poll(), y = Q.poll();
                if (x == point[1][0] && y == point[1][1]) {
                    ans = time;
                    return;
                }
                for (int k = 0; k < 4; k++) {
                    int nx = x + dir[k][0], ny = y + dir[k][1];
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if (visited[nx][ny]) continue;
                    if (A[nx][ny] == 1) continue;
                    if (A[nx][ny] == 2 && time % 3 != 2) {
                        Q.add(x);
                        Q.add(y);
                        continue;
                    }
                    visited[nx][ny] = true;
                    Q.add(nx);
                    Q.add(ny);
                }
            }
            time++;
        }
    }

    static void pro() {
        ans = -1;
        bfs(point[0][0], point[0][1]);
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            input();
            pro();
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }
}
