import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        arr2 = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static int[][] arr, arr2;
    static boolean[][] visit;
    static int N, M, R;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void pro(int R) {
        for (int r = 0; r < R; r++) { // 1번 반복 마다 1칸 이동
            visit = new boolean[N][M];
            int x = 0, y = 0, d = 0, num=0 ,px = 0, py = 0;
            arr2[x][y] = arr[x+dir[1][0]][y+dir[1][1]];
            visit[x][y] = true;
            num++;
            px = x;
            py = y;
            x = x + dir[d][0]; y = y + dir[d][1];
            while(true){
                if (num == M * N - 1) break;
                int nx = x + dir[d][0], ny = y + dir[d][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny]) {
                    d++;
                    d = d % 4;
                    if(d == 0){
                        num++;
                        arr2[x][y] = arr[px][py];
                        visit[x][y] = true;
                        x = x + dir[d][0]; y = y + dir[d][1]; px = x + dir[1][0]; py = y + dir[1][1];
                    }
                    continue;
                }

                num++;
                arr2[x][y] = arr[px][py];
                visit[x][y] = true;
                px = x; py = y; x = nx; y = ny;
            }
            arr2[x][y] = arr[px][py];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    arr[i][j] = arr2[i][j];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro(R);
        System.out.print(sb.toString());
    }
}
