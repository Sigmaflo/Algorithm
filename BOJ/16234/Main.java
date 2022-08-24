import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] A;
    static int N, L, R, C, ans;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static Country[] countries;
    static HashSet<Integer> groups;
    static int[][] countries_number;
    static boolean[][] visit;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        countries_number = new int[N][N];
        countries = new Country[N*N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static class Country {
        int x, y, size;

        public Country(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }

    static boolean find_moved_country() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    int adx = i + dir[k][0], ady = j + dir[k][1];
                    if (adx < 0 || ady < 0 || adx >= N || ady >= N) continue;
                    if (Math.abs(A[i][j] - A[adx][ady]) < L) continue;
                    if (Math.abs(A[i][j] - A[adx][ady]) > R) continue;
                    return true;
                }
            }
        }
        return false;
    }
    static int bfs(int sx, int sy) {
        groups = new HashSet<>();
        Queue<Integer> Q = new LinkedList<>();
        Q.add(sx);
        Q.add(sy);
        visit[sx][sy] = true;
        groups.add(countries_number[sx][sy]);
        while(!Q.isEmpty()) {
            int x = Q.poll(), y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visit[nx][ny]) continue;
                if (Math.abs(A[x][y] - A[nx][ny]) < L) continue;
                if (Math.abs(A[x][y] - A[nx][ny]) > R) continue;
                visit[nx][ny] = true;
                groups.add(countries_number[nx][ny]);
                Q.add(nx);
                Q.add(ny);
            }
        }
        if (groups.size() == 1) return 1;
        int sum = 0;
        for (int num: groups) {
            Country country = countries[num];
            sum += country.size;
        }
        int n = sum / groups.size();
        for (int num: groups) {
            Country country = countries[num];
            country.size = n;
            A[country.x][country.y] = n;
        }
        return groups.size();
    }

    static void pro() {
        C = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                countries[C] = new Country(i, j, A[i][j]);
                countries_number[i][j] = C;
                C++;
            }
        }
        ans = 0;
        while(find_moved_country()) {
            visit = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visit[i][j]) bfs(i, j);
                }
            }
            ans++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
