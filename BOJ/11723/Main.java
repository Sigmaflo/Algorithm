import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> ht = new HashMap<>();
        int m = Integer.parseInt(br.readLine());
        for(int i = 1; i <=20; i++){
            ht.put(Integer.toString(i), 0);
        }
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("add")){
                String x = st.nextToken();
                ht.put(x, 1);
            }else if(command.equals("remove")){
                String x = st.nextToken();
                ht.put(x, 0);
            }else if(command.equals("check")){
                String x = st.nextToken();
                bw.write(ht.get(x)+"");
                bw.newLine();
            }else if(command.equals("toggle")){
                String x = st.nextToken();
                if(ht.get(x) == 1){
                    ht.put(x, 0);
                }else{
                    ht.put(x, 1);
                }
            }else if(command.equals("all")){
                ht.replaceAll((k, v) -> 1);
            }else if(command.equals("empty")){
                ht.replaceAll((k, v) -> 0);
            }
        }
        bw.flush();
        bw.close();
    }
}
