import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        short[] arr = new short[10001];
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            short num = Short.parseShort(br.readLine());
            arr[num]++;
        }
        for(int i = 1; i < arr.length; i++){
            if(arr[i] != 0){
                for(int s = 0; s < arr[i]; s++){
                    bw.write(Integer.toString(i));
                    bw.newLine();
                }
            }
        }
        bw.flush();
        bw.close();
    }
}
