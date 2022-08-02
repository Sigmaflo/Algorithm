import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    static int[] switches;

    static void boy(int num, int n){
        if(num > switches.length-1){
            return;
        }
        switches[num] = switches[num] == 0 ? 1 : 0;
        boy(num+n, n);
    }

    static void girl(int num, int n){
        if(num - n < 1 || num + n > switches.length - 1){
            return;
        }
        if(switches[num-n] != switches[num+n]){
            return;
        }
        switches[num-n] = switches[num-n] == 0 ? 1 : 0;
        switches[num+n] = switches[num+n] == 0 ? 1 : 0;
        girl(num, n+1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        switches = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            switches[i] = Integer.parseInt(st.nextToken());
        }
        int peolpe = Integer.parseInt(br.readLine());
        for(int p = 0; p < peolpe; p++){
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(sex == 1){
                boy(num, num);
            }else if(sex == 2){
                switches[num] = switches[num] == 0 ? 1 : 0;
                girl(num, 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < switches.length; i++){
            sb.append(switches[i]);
            if(i % 20 == 0){
                sb.append('\n');
            }else{
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }
}
