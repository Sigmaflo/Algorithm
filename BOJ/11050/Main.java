import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int a = 1;
        int b = 1;
        int c = 1;
        for(int i = 1; i <=n; i++){
            a *= i;
        }
        for(int i = 1; i <= k; i++){
            b *= i;
        }
        for(int i = 1; i <= (n - k); i++){
            c *= i;
        }
        System.out.println(a / (b * c));
    }
}
