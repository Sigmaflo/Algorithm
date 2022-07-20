import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arrayList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arrayList.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arrayList);
        int[] cache = new int[N];
        cache[0] = arrayList.get(0);
        for(int i = 1; i < N; i++){
            cache[i] = cache[i-1] + arrayList.get(i);
        }
        int sum = 0;
        for(int time : cache){
            sum += time;
        }
        System.out.println(sum);
    }
}
