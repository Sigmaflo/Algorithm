import java.util.*;
import java.io.*;

public class Main {
    static BufferedWriter bw;

    private static void print_number(double d) throws IOException{
        bw.write(String.format("%d", (int)d));
        bw.newLine();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Double> num_list = new ArrayList<>();
        Map<Double, Integer> ht = new HashMap<>();
        int n = Integer.parseInt(br.readLine());
        int max_count = 0;
        List<Double> max_count_num_list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            double num = Double.parseDouble(br.readLine());
            num_list.add(num);
            if(ht.containsKey(num)){
                ht.put(num, ht.get(num) + 1);
            }else{
                ht.put(num, 1);
            }
            if(ht.get(num) > max_count){
                max_count = ht.get(num);
                max_count_num_list.clear();
                max_count_num_list.add(num);
            }else if(ht.get(num) == max_count){
                max_count_num_list.add(num);
            }
        }
        Collections.sort(num_list);
        double sum = 0;
        for(double num : num_list){
            sum += num;
        }
        double avarage = sum / num_list.size();
        print_number(Math.round(avarage));
        print_number(num_list.get(num_list.size() / 2));
        if(max_count_num_list.size() == 1){
            print_number(max_count_num_list.get(0));
        }else{
            Collections.sort(max_count_num_list);
            print_number(max_count_num_list.get(1));
        }
        print_number(Math.abs(num_list.get(0) - num_list.get(num_list.size()-1)));
        bw.flush();
        bw.close();
    }
}
