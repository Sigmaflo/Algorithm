import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] board;
    static boolean[][] visit;
    static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int[][] dist_water, dist_hedgehog;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][];
        visit = new boolean[R][C];
        dist_water = new int[R][C];
        dist_hedgehog = new int[R][C];
        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }
    }

    static void bfs_water() {
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                dist_water[i][j] = -1;
                visit[i][j] = false;
                if(board[i][j] == '*') {
                    Q.add(i);
                    Q.add(j);
                    dist_water[i][j] = 0;
                    visit[i][j] = true;
                }
            }
        }

        while(!Q.isEmpty()) {
            int x = Q.poll(), y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (board[nx][ny] != '.') continue;
                if (visit[nx][ny]) continue;
                visit[nx][ny] = true;
                dist_water[nx][ny] = dist_water[x][y] + 1;
                Q.add(nx);
                Q.add(ny);
            }
        }
    }

    static void bfs_hedgehog() {
        Queue<Integer> Q = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                dist_hedgehog[i][j] = -1;
                visit[i][j] = false;
                if(board[i][j] == 'S') {
                    Q.add(i);
                    Q.add(j);
                    dist_hedgehog[i][j] = 0;
                    visit[i][j] = true;
                }
            }
        }
        while(!Q.isEmpty()) {
            int x = Q.poll(), y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
                if (board[nx][ny] != '.' && board[nx][ny] != 'D') continue;
                if (dist_water[nx][ny] != -1 && dist_water[nx][ny] <=  dist_hedgehog[x][y] + 1) continue;
                if (visit[nx][ny]) continue;
                Q.add(nx);
                Q.add(ny);
                visit[nx][ny] = true;
                dist_hedgehog[nx][ny] = dist_hedgehog[x][y] + 1;
            }
        }
    }

    static void pro() {
        bfs_water();
        bfs_hedgehog();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 'D') {
                    if (dist_hedgehog[i][j] == -1) {
                        System.out.println("KAKTUS");
                    } else {
                        System.out.println(dist_hedgehog[i][j]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
