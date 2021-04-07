import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, String> ht = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            String num = st.nextToken();
            ht.put(num, "1");
        }
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            String num = st.nextToken();
            bw.write(ht.getOrDefault(num, "0"));
            bw.newLine();
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
