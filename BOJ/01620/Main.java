import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Integer> name_to_num = new HashMap<>();
        Map<Integer, String> num_to_name = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++){
            String poketmon = br.readLine();
            name_to_num.put(poketmon, i + 1);
            num_to_name.put(i + 1, poketmon);
        }
        for(int i = 0; i < m; i++){
            String q = br.readLine();
            if(Character.isDigit(q.charAt(0))){
                bw.write(num_to_name.get(Integer.parseInt(q)));
            }else{
                bw.write(name_to_num.get(q)+"");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
