import java.util.*;
import java.io.*;

public class Main {
    static long[] lan;
    static int n;

    private static int cut(long mid){
        int sum = 0;
        for(long l : lan){
            sum += l/mid;
        }
        return sum;
    }

    private static long find_max(long right){
        long left = 1;
        long max = 0;
        while(left <= right){
            long mid = (left+right) / 2;
            int sum = cut(mid);
            if(sum < n){
                right = mid - 1;
            }else{
                left = mid + 1;
                if(mid > max){
                    max = mid;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        lan = new long[k];
        long max = 0;
        for(int i = 0; i < k; i++){
            lan[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lan[i]);
        }
        long r = find_max(max);
        System.out.println(r);
    }
}
