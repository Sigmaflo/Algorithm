import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, P, G, ans;
    static char[][] A;
    static boolean[][][] visited;
    static Queue<Dot> Q;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new char[M][];
        visited = new boolean[M][N][1<<5];
        for (int i = 0; i < M; i++) A[i] = br.readLine().toCharArray();
    }

    static class Dot {
        int x, y, product;

        public Dot(int x, int y, int product) {
            this.x = x;
            this.y = y;
            this.product =product;
        }

    }

    static void bfs() {
        int dist = 0;
        while(!Q.isEmpty()) {
            int size = Q.size();
            dist++;
            for (int s = 0; s < size; s++) {
                Dot dot = Q.poll();
                int x = dot.x, y = dot.y, nowProduct = dot.product;
                if (A[x][y] == 'E') {
                    if (nowProduct == G) {
                        ans = dist - 1;
                        return;
                    }
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int nx = x + dir[k][0], ny = y + dir[k][1];
                    if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                    if (A[nx][ny] == '#') continue;
                    if (visited[nx][ny][nowProduct]) continue;
                    if (A[nx][ny] >= '0' && A[nx][ny] <= '4') { // 물건을 발견했을 때
                        int newProduct = 1 << (A[nx][ny] - '0');
                        int addedProduct = nowProduct | newProduct;
                        visited[nx][ny][addedProduct] = true;
                        Q.add(new Dot(nx, ny, addedProduct));
                    } else {
                        visited[nx][ny][nowProduct] = true;
                        Q.add(new Dot(nx, ny, nowProduct));
                    }
                }
            }
        }
    }

    static void pro() {
        Q = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j] == 'X') {
                    A[i][j] = (char)(P + '0');
                    G = G | 1 << P;
                    P++;
                } else if(A[i][j] == 'S') {
                    visited[i][j][0] = true;
                    Q.add(new Dot(i, j, 0));
                }
            }
        }
        bfs();
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}