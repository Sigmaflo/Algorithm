import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int minSetPice = 1001;
        int minOnePice = 1001;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            minSetPice = Math.min(minSetPice, Integer.parseInt(st.nextToken()));
            minOnePice = Math.min(minOnePice, Integer.parseInt(st.nextToken()));
        }
        int totalPrice = 0;
        if(minSetPice - minOnePice * 6 > 0){
            totalPrice += minOnePice * N;
        }else{
            int count1 = N / 6;
            int count2 = N % 6;
            totalPrice += minSetPice * count1;
            if((minOnePice * count2) - minSetPice > 0){
                totalPrice += minSetPice;
            }else{
                totalPrice += minOnePice * count2;
            }
        }
        System.out.println(totalPrice);
    }
}
