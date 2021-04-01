import java.util.*;

public class Main {
    private static boolean is_end_num(int num){
        String str = Integer.toString(num);
        return str.contains("666");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int o = 666;
        int nth = 0;
        while(true){
            if(is_end_num(o)){
                nth++;
                if(nth == n){
                    break;
                }
            }
            o++;
        }
        System.out.println(o);
    }
}
