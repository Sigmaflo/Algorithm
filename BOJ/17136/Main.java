import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int ans;
    static int[][] A;
    static int[] paper = {0, 5, 5, 5, 5, 5};

    static boolean[][] visit;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = new int[10][10];
        visit = new boolean[10][10];
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static void stick_papper(int x, int y, int size, boolean state) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                visit[i][j] = state;
            }
        }
    }

    static boolean isStick(int x, int y, int size) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (i < 0 || i >= 10 || j < 0 || j >= 10) return false;
                if (A[i][j] != 1) return false;
                if (visit[i][j]) return false;
            }
        }
        return true;
    }

    static void dfs(int x, int y, int cnt) {
        if(x >= 9 && y > 9) {
            ans = Math.min(ans, cnt);
            return;
        }

        if (ans <= cnt) {
            return;
        }

        if (y > 9) {
            dfs(x + 1, 0, cnt);
            return;
        }

        if (A[x][y] == 1 && !visit[x][y]) {
            for (int size = 5; size >= 1; size--) {
                if (paper[size] > 0 && isStick(x, y, size)) {
                    paper[size]--;
                    stick_papper(x, y, size, true);
                    dfs(x, y + 1, cnt + 1);
                    stick_papper(x, y, size, false);
                    paper[size]++;
                }
            }
        } else {
            dfs(x, y + 1, cnt);
        }
    }

    static void pro() {
        ans = Integer.MAX_VALUE;
        dfs(0, 0, 0);
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}