import java.util.*;
import java.io.*;

public class Main {
    public static boolean isDecimal(int num){
        for(int i = 2; i*i <= num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = scan.nextInt();
        int b = scan.nextInt();
        if(a == 1){
            a++;
        }
        for(int n = a; n <= b; n++){
            if(isDecimal(n)){
                bw.write(Integer.toString(n));
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}
