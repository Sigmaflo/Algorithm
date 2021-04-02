import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int th = 1;
        int m = 1;
        while(true){
            if(n <= m){
                break;
            }
            th++;
            m = m + 6 * (th - 1);
        }
        System.out.println(th);
    }
}
