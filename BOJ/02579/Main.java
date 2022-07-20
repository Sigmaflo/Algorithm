import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int[] stairs;

    static int[] cache;

    public static int dp(int s){
        for(int i = 3; i <= n; i++){
            cache[i] = Math.max(cache[i-2], cache[i-3] + stairs[i-1]) + stairs[i];
        }

        return cache[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        stairs = new int[n+1];
        cache = new int[n+1];
        for(int i = 1; i <= n; i++){
            stairs[i] = Integer.parseInt(br.readLine());
            cache[i] = 0;
        }
        stairs[0] = 0;
        cache[0] = stairs[0];
        cache[1] = stairs[1];
        if(n >= 2){
            cache[2] = stairs[1] + stairs[2];
        }
        int result = dp(3);
        System.out.println(result);
    }
}
