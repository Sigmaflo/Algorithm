import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int R, C, S;
    static char[][] A;
    static int[] stones;
    static Stack<Dot>[] stacks;
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        A = new char[R][C];
        for (int i = 0; i < R; i++) A[i] = br.readLine().toCharArray();
        S = Integer.parseInt(br.readLine());
        stones = new int[S];
        for (int i = 0; i < S; i++) stones[i] = Integer.parseInt(br.readLine()) - 1;
        stacks = new Stack[C];
        for (int i = 0; i < C; i++) stacks[i] = new Stack<>();
    }

    static class Dot {
        int x, y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void set_firstpath() {
        for (int stone = 0; stone < C; stone++) {
            int x = 0;
            int y = stone;
            stacks[stone].add(new Dot(x, y));
            //CASE2: 아래칸이 비어 있으면 아래칸을 내려간다.
            //CASE1: 가장 아랫줄 이거나 막혀 있을 때
            while(true) {
                int nx = x + 1;
                if (nx >= R) break;  // 가장 아랫 줄일떄
                if (A[nx][y] == 'X') break; // 막혀 있을 때
                x = nx;
                stacks[stone].add(new Dot(x, y));
            }
        }
    }

    static void set_secondpath(int stone) {
        int x = stacks[stone].peek().x;
        int y = stacks[stone].peek().y;
        boolean con = true;
        while (con) {
            boolean foundstone = false; // 돌이 있을 때
            if (A[x + 1][y] == 'O') {
                //3-1: 왼쪽칸과 왼쪽 아래칸이 비어 있다면
                if (y > 0 && A[x][y - 1] == '.' && A[x + 1][y - 1] == '.') {
                    y = y - 1;
                    x = x + 1;
                    stacks[stone].add(new Dot(x, y));
                    while(true) {
                        int nx = x + 1;
                        if (nx >= R) break;
                        if (A[nx][y] == 'X') break;
                        if (A[nx][y] == 'O') {
                            foundstone = true; // 돌이 있을 때는 큰 while 반복문 다시 반복
                            break;
                        }
                        x = nx;
                        stacks[stone].add(new Dot(x, y));
                    }
                } else if (y < C - 1 && A[x][y + 1] == '.' && A[x + 1][y + 1] == '.') {
                    //3-2: 오른쪽칸과 오른쪽 아래칸이 비어 있다면
                    y = y + 1;
                    x = x + 1;
                    stacks[stone].add(new Dot(x, y));
                    while(true) {
                        int nx = x + 1;
                        if (nx >= R) break;
                        if (A[nx][y] == 'X') break;
                        if (A[nx][y] == 'O') { // 돌이 있을 때는 큰 while 반복문 다시 반복
                            foundstone = true;
                            break;
                        }
                        x = nx;
                        stacks[stone].add(new Dot(x, y));
                    }
                }
                // 3-3: 3-1, 3-2 가 아니라면 멈춘다
            }
            if(!foundstone) con = false; // 막혀있거나 돌이 없다면 반복문 종료
        }
    }

    static void pro() {
        set_firstpath();
        for (int stone : stones) {
            if (stacks[stone].isEmpty()) continue;
            if (A[stacks[stone].peek().x][stacks[stone].peek().y] == 'O') {
                while (A[stacks[stone].peek().x][stacks[stone].peek().y] != '.') {
                    if (stacks[stone].isEmpty()) break;
                    stacks[stone].pop();
                }
            }
            if (!stacks[stone].isEmpty() && A[stacks[stone].peek().x][stacks[stone].peek().y] == '.') {
                int x = stacks[stone].peek().x, y = stacks[stone].peek().y;
                if (x + 1 < R && A[x + 1][y] == 'O') {
                    set_secondpath(stone);
                    x = stacks[stone].peek().x;
                    y = stacks[stone].peek().y;
                }
                A[x][y] = 'O';
                stacks[stone].pop();
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(A[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}