import java.util.Scanner;

public class Main {
    static StringBuilder[] sb;
    static int N;

    static void write(int state, int line) {
        if(state == 1) {
            sb[line-2].append("***");
            sb[line-1].append("* *");
            sb[line].append("***");
        } else { // state == 0
            sb[line-2].append("   ");
            sb[line-1].append("   ");
            sb[line].append("   ");
        }
    }

    static void rec_func(int n,  int state, int line) {
        if (n == 3) {
            write(state, line);
            return;
        }
        if (state == 0) {
            rec_func(n / 3, 0, line - n / 3 * 2);
            rec_func(n / 3, 0, line - n / 3 * 2);
            rec_func(n / 3, 0, line - n / 3 * 2);
            rec_func(n / 3, 0, line - n / 3);
            rec_func(n / 3, 0, line - n / 3);
            rec_func(n / 3, 0, line - n / 3);
            rec_func(n / 3, 0, line);
            rec_func(n / 3, 0, line);
            rec_func(n / 3, 0, line);
        } else {
            rec_func(n / 3, 1, line - n / 3 * 2);
            rec_func(n / 3, 1, line - n / 3 * 2);
            rec_func(n / 3, 1, line - n / 3 * 2);
            rec_func(n / 3, 1, line - n / 3);
            rec_func(n / 3, 0, line - n / 3);
            rec_func(n / 3, 1, line - n / 3);
            rec_func(n / 3, 1, line);
            rec_func(n / 3, 1, line);
            rec_func(n / 3, 1, line);
        }

    }

    static void pro() {
        sb = new StringBuilder[N + 1];
        for (int i = 1; i <= N; i++) sb[i] = new StringBuilder();
        rec_func(N, 1, N);
        for (int i = 1; i <= N; i++) {
            System.out.println(sb[i].toString());
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        pro();
    }
}
