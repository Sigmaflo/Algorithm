import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int max = 0;
        int min = 0;
        boolean is_find_max = false;
        for(int n = 1; n <= a*b; n++){
            if(a % n == 0 && b % n == 0){
                min = n;
            }
            if(n % a == 0 && n % b == 0){
                max = n;
                is_find_max = true;
            }
            if(is_find_max){
                break;
            }
        }
        System.out.println(min);
        System.out.println(max);
    }
}
