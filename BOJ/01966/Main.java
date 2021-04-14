import java.util.*;
import java.io.*;

public class Main {
    static class Number{
        int value;
        int index;

        public Number(int value, int index){
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            Queue<Number> queue = new LinkedList<>();
            List<Integer> value_list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int k = 0; k < n; k++){
                Number num = new Number(Integer.parseInt(st.nextToken()), k);
                queue.offer(num);
                value_list.add(num.value);
            }
            Collections.sort(value_list);
            int k = 1;
            while(!queue.isEmpty()){
                int max_value = value_list.get(value_list.size() - k);
                Number num = queue.poll();
                if(num.value != max_value){
                    queue.add(num);
                }else{
                    if(num.index == m){
                        break;
                    }
                    k++;
                }
            }
            bw.write(Integer.toString(k));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
