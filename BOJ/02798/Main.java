import java.util.*;
import java.io.*;

public class Main {
    static List<Integer> num_list;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num_list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            num_list.add(Integer.parseInt(st.nextToken()));
        }
        int result = 0;
        for(int i = 0; i < num_list.size()-2; i++){
            for(int j = i + 1; j < num_list.size()-1; j++){
                for(int l = j + 1; l < num_list.size(); l++){
                    int sum = num_list.get(i) + num_list.get(j) + num_list.get(l);
                    if(sum <= m && sum > result){
                        result = sum;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
