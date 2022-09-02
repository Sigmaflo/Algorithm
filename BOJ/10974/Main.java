import java.util.Scanner;

public class Main {
    static int N;
    static int[] result;
    static boolean[] selected;
    static StringBuilder sb = new StringBuilder();

    static void rec_func(int k) {
        if (k == N) {
            for(int i = 0; i < N; i++) sb.append(result[i]).append(' ');
            sb.append('\n');
            return;
        }
        for (int i = 1; i <= N; i++) {
            if(selected[i]) continue;
            result[k] = i;
            selected[i] = true;
            rec_func(k + 1);
            selected[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        result = new int[N];
        selected = new boolean[N + 1];
        rec_func(0);
        System.out.print(sb.toString());
    }

}
