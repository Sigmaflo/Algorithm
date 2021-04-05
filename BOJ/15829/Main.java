import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    private static int text_to_int(char str){
        return (int)str - 96;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigInteger r = BigInteger.valueOf(31);
        int M = 1234567891;
        int L = scan.nextInt();
        String text = scan.next();
        BigInteger sum = BigInteger.ZERO;
        for(int i = 0; i < L; i++){
//            int s = text_to_int(text.charAt(i)) * (int)Math.pow(r, i);
            BigInteger t = r.pow(i);
            BigInteger y = BigInteger.valueOf(text_to_int(text.charAt(i)));
            BigInteger s = t.multiply(y);
            sum = sum.add(s);
        }
        System.out.println(sum.mod(BigInteger.valueOf(M)));
    }
}
