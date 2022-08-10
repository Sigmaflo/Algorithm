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
        board = new int[N + 1][M + 1];
        cmds = new int[R];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            cmds[i] = Integer.parseInt(st.nextToken());
        }
    }

    static int N, M, R;
    static int[][] board;
    static int[] cmds;

    static void swap_ud(int op1, int op2) {
        int[] arr1 = board[op1].clone();
        int[] arr2 = board[op2].clone();
        board[op1] = arr2;
        board[op2] = arr1;
    }

    static void swap_lr(int op1, int op2) {
        for(int i = 1; i <= N; i++) {
            int t = board[i][op1];
            board[i][op1] = board[i][op2];
            board[i][op2] = t;
        }
    }

    static int[][] get_sub(int d) {
        int[][] sub = new int[N / 2 + 1][M / 2 + 1];
        if(d == 1) {
            int x = 1;
            int y = 1;
            for(int i = 1; i <= N / 2; i++) {
                for (int j = 1; j <= M / 2; j++) {
                    int a = board[i][j];
                    sub[x][y] = board[i][j];
                    y++;
                }
                x++;
                y = 1;
            }
        } else if (d == 2) {
            int x = 1;
            int y = 1;
            for(int i = 1; i <= N / 2; i++) {
                for (int j = M / 2 + 1; j <= M; j++) {
                    sub[x][y] = board[i][j];
                    y++;
                }
                x++;
                y = 1;
            }
        } else if (d == 3) {
            int x = 1;
            int y = 1;
            for(int i = N / 2 + 1; i <= N; i++) {
                for (int j = 1; j <= M / 2; j++) {
                    sub[x][y] = board[i][j];
                    y++;
                }
                x++;
                y = 1;
            }
        } else { // d == 4
            int x = 1;
            int y = 1;
            for(int i = N / 2 + 1; i <= N; i++) {
                for (int j = M / 2 + 1; j <= M; j++) {
                    sub[x][y] = board[i][j];
                    y++;
                }
                x++;
                y = 1;
            }
        }
        return sub;
    }

    static void set_sub(int d, int[][] sub) {
        if(d == 1) {
            int x = 1;
            int y = 1;
            for(int i = 1; i <= N / 2; i++) {
                for (int j = 1; j <= M / 2; j++) {
                    board[i][j] = sub[x][y];
                    y++;
                }
                x++;
                y = 1;
            }
        } else if (d == 2) {
            int x = 1;
            int y = 1;
            for(int i = 1; i <= N / 2; i++) {
                for (int j = M / 2 + 1; j <= M; j++) {
                    board[i][j] = sub[x][y];
                    y++;
                }
                x++;
                y = 1;
            }
        } else if (d == 3) {
            int x = 1;
            int y = 1;
            for(int i = N / 2 + 1; i <= N; i++) {
                for (int j = 1; j <= M / 2; j++) {
                    board[i][j] = sub[x][y];
                    y++;
                }
                x++;
                y = 1;
            }
        } else { // d == 4
            int x = 1;
            int y = 1;
            for(int i = N / 2 + 1; i <= N; i++) {
                for (int j = M / 2 + 1; j <= M; j++) {
                    board[i][j] = sub[x][y];
                    y++;
                }
                x++;
                y = 1;
            }
        }
    }

    static void pro(int r) {
        for (int cmd : cmds) {
            if (cmd == 1) {
                int d = N - 1;
                for (int i = 1; i <= N/2; i++) {
                    swap_ud(i, i + d);
                    d -= 2;
                }
            } else if (cmd == 2) {
                int d = M - 1;
                for (int j = 1; j <= M/2; j++) {
                    swap_lr(j, j + d);
                    d -= 2;
                }
            } else if (cmd == 3) {
                int[][] new_board = new int[M + 1][N + 1];
                int x = 1;
                int y = 1;
                for (int j = 1; j <= M; j++) {
                    for (int i = N; i > 0; i--) {
                        new_board[x][y] = board[i][j];
                        y++;
                    }
                    x++;
                    y = 1;
                }
                board = new_board;
                int n = N;
                N = M;
                M = n;
            } else if (cmd == 4) {
                int[][] new_board = new int[M + 1][N + 1];
                int x = 1;
                int y = 1;
                for(int j = M; j > 0; j--) {
                    for (int i = 1; i <= N; i++) {
                        new_board[x][y] = board[i][j];
                        y++;
                    }
                    x++;
                    y = 1;
                }
                board = new_board;
                int n = N;
                N = M;
                M = n;
            } else if (cmd == 5) {
                int[][] sub1 = get_sub(1);
                int[][] sub2 = get_sub(2);
                int[][] sub3 = get_sub(3);
                int[][] sub4 = get_sub(4);
                set_sub(1, sub3);
                set_sub(2, sub1);
                set_sub(3, sub4);
                set_sub(4, sub2);
            } else { // cmd == 6
                int[][] sub1 = get_sub(1);
                int[][] sub2 = get_sub(2);
                int[][] sub3 = get_sub(3);
                int[][] sub4 = get_sub(4);
                set_sub(1, sub2);
                set_sub(2, sub4);
                set_sub(3, sub1);
                set_sub(4, sub3);
            }
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append('\n');
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro(R);
        System.out.println(sb.toString());
    }
}
