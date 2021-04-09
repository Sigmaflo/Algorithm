import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i = 0; i < t; i++){
            int h = scan.nextInt(); // 6
            int w = scan.nextInt(); // 12
            int n = scan.nextInt(); // 10
            int a = n / h; // 1
            int b = n % h; // 4
            int c = 1 + a;
            int r = h;
            if(n % h != 0){
                r = b;
            }else{
                c--;
            }
            System.out.print(r);
            System.out.printf("%02d", c);
            System.out.println();
            scan.nextLine();
        }
    }
}
