import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 1; t <= 10; t++){
            int dump = Integer.parseInt(br.readLine());
            int[] arr = new int[100];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < arr.length; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int d = 0; d < dump; d++){
                int minIndex = -1;
                int minHeight = 101;
                int maxIndex = -1;
                int maxHeight = 0;
                for(int i = 0; i < arr.length; i++){
                    if(arr[i] < minHeight){
                        minIndex = i;
                        minHeight = arr[i];
                    }
                    if(arr[i] > maxHeight){
                        maxIndex = i;
                        maxHeight = arr[i];
                    }
                }
                arr[maxIndex] -= 1;
                arr[minIndex] += 1;
            }
            int minHeight = 101;
            int maxHeight = 0;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] < minHeight){
                    minHeight = arr[i];
                }
                if(arr[i] > maxHeight){
                    maxHeight = arr[i];
                }
            }
            System.out.printf("#%d %d\n", t, maxHeight - minHeight);
        }
    }
}
