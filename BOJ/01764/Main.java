import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> ht = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            ht.put(br.readLine(), 1);
        }
        List<String> result = new ArrayList<>();
        for(int i = 0; i < m; i++){
            String name = br.readLine();
            if(ht.containsKey(name)){
                result.add(name);
            }
        }
        bw.write(result.size()+"");
        bw.newLine();
        Collections.sort(result);
        for(String name : result){
            bw.write(name);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
