import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            arr.add(num);
        }
        Collections.sort(arr);
        for(int num : arr){
            bw.write(Integer.toString(num));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
