import java.util.Scanner;

public class Main {
    static int N, ans;

    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
    }

    static void pro() {
        int n = N;
        while (n >= 3) {
           if (n >= 15) {
               n -= 5;
               ans++;
           } else if (n % 3 == 0) {
               n -= 3;
               ans++;
           } else {
               n -= 5;
               ans++;
           }
        }
        if (n == 0) {
            System.out.println(ans);
        } else {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
