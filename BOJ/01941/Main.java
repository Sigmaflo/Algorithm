import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] A;
    static boolean[] select;
    static int ans;
    static Student[] students;
    static int[][] dir = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    static class Student {
        int x, y;
        char id;

        public Student(int x, int y, char id) {
            this.x = x;
            this.y = y;
            this.id = id;
        }
    }
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = new char[5][];
        for (int i = 0; i < 5; i++) {
            A[i] = br.readLine().toCharArray();
        }
    }

    static void calculation(Student[] result) {
        Queue<Integer> Q = new LinkedList<>();
        boolean[][] visit = new boolean[25][25];
        boolean[][] select = new boolean[25][25];
        int count = 0, ss = 0;
        for (Student student: result) {
            select[student.x][student.y] = true;
            if (student.id == 'S') ss++;
        }
        if (ss <= 3) return;
        Q.add(result[0].x);
        Q.add(result[0].y);
        visit[result[0].x][result[0].y] = true;
        count++;
        while(!Q.isEmpty()) {
            int x = Q.poll(), y = Q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = x + dir[k][0], ny = y + dir[k][1];
                if (nx < 0 || ny < 0 || nx >= 25 || ny >= 25) continue;
                if (!select[nx][ny]) continue;
                if (visit[nx][ny]) continue;
                visit[nx][ny] = true;
                count++;
                Q.add(nx);
                Q.add(ny);
            }
        }
        if (count != 7) return;
        ans++;
    }

    static void rec_func(int k, int cnt) {
        if (cnt == 7) {
            Student[] result = new Student[7];
            int d = 0;
            for (int i = 0; i < 25; i++) {
                if (select[i]){
                    result[d] = students[i];
                    d++;
                }
            }
            calculation(result);
            return;
        }
        if (k == 25) return;
        select[k] = true;
        rec_func(k + 1, cnt + 1);
        select[k] = false;
        rec_func(k + 1, cnt);
    }

    static void pro() {
        students = new Student[25];
        int k = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                students[k] = new Student(i, j, A[i][j]);
                k++;
            }
        }
        select = new boolean[25];
        rec_func(0, 0);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
