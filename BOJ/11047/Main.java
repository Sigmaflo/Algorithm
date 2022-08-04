import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int K = scan.nextInt();
        int[] coin = new int[N];
        for(int i = 0; i < N; i++){
            coin[i] = scan.nextInt();
        }
        int count = 0;
        int sum = K;
        while(sum != 0){
            for(int i = coin.length-1; i >= 0; i--){
                if(sum - coin[i] >= 0){
                    count++;
                    sum -= coin[i];
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
