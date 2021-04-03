import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] len = new int[3];
        len[0] = scan.nextInt();
        len[1] = scan.nextInt();
        len[2] = scan.nextInt();
        Arrays.sort(len);
        while(true){
            if(len[0] == 0 && len[1] == 0 && len[2] == 0){
                break;
            }
            if(len[0]*len[0] + len[1]*len[1] - len[2]*len[2] == 0){
                System.out.println("right");
            }else{
                System.out.println("wrong");
            }
            len[0] = scan.nextInt();
            len[1] = scan.nextInt();
            len[2] = scan.nextInt();
            Arrays.sort(len);
        }
    }
}
