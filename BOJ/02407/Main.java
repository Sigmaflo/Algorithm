import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        if(n - m < m){
            m = n - m;
        }
        BigInteger A = BigInteger.valueOf(n);
        for(int i = n-1; i > n-m; i--){
            A = A.multiply(BigInteger.valueOf(i));
        }
        BigInteger B = BigInteger.valueOf(1);
        for(int i = 2; i<= m; i++){
            B = B.multiply(BigInteger.valueOf(i));
        }
        System.out.println(A.divide(B));
    }
}
