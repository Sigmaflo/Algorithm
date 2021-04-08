import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> ht = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            String num = st.nextToken();
            if(!ht.containsKey(num)){
                ht.put(num, 1);
            }else{
                ht.put(num, ht.get(num) + 1);
            }
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            String num = st.nextToken();
            bw.write( Integer.toString(ht.getOrDefault(num, 0)) + " ");
        }
        bw.flush();
        bw.close();
    }
}
