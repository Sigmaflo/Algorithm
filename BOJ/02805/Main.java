import java.util.*;
import java.io.*;

public class Main {
    static List<Integer> lumbers;
    static int m;

    private static long cut(int len){
        long sum = 0;
        for(int lumber : lumbers){
            if(lumber - len > 0){
                sum += (lumber - len);
            }
        }
        return sum;
    }

    private static int get_max_h(int high){
        int low = 0;
        int max_height = 0;
        while(low <= high){
            int mid = (low+high)/2;
            long sum = cut(mid);
            if(sum < m)
                high = mid-1;
            else {
                max_height = mid;
                low = mid+1;
            }
        }
        return max_height;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        lumbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int max = Integer.MIN_VALUE;
        while(st.hasMoreTokens()){
            int l = Integer.parseInt(st.nextToken());
            lumbers.add(l);
            max = Math.max(max, l);
        }
        int result = get_max_h(max);
        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
    }
}
