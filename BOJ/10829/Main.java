import java.util.Scanner;

public class Main {
    private static String decimal_to_binary(long n){
        if(n == 0){
            return "0";
        }else if(n == 1){
            return "1";
        }
        if(n % 2 == 0){
            return decimal_to_binary(n/2) + "0";
        }else{
            return decimal_to_binary(n/2) + "1";
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        String binary = decimal_to_binary(n);
        System.out.println(binary);
    }
}
