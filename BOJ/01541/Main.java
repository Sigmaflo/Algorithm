import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");
        int area = st.countTokens();
        int[] sum = new int[area];
        for(int i = 0; i < area; i++){
            StringTokenizer st2 = new StringTokenizer(st.nextToken(), "+");
            int s = 0;
            while(st2.hasMoreTokens()){
                s += Integer.parseInt(st2.nextToken());
            }
            sum[i] = s;
        }
        int result = sum[0];
        for(int i = 1; i < sum.length; i++){
            result -= sum[i];
        }
        System.out.println(result);
    }
}
