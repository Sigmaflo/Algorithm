import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, String> ht = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            ht.put(st.nextToken(), "1");
        }
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            if(ht.containsKey(st.nextToken())){
                System.out.print("1 ");
            }else{
                System.out.print("0 ");
            }
        }
    }
}
