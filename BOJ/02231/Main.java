import java.util.*;

public class Main {
    private static boolean is_sub_sum(int n, int t){
        int n2 = t;
        while(t != 0){
            n2 += t % 10;
            t /= 10;
        }
        return n == n2;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int r = 0;
        for(int i = 1; i <= n; i++){
            if(is_sub_sum(n, i)){
                r = i;
                break;
            }
        }
        System.out.println(r);
    }
}
