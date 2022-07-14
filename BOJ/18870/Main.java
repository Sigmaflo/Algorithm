import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> arr2;
        HashMap<Integer, Integer> ht = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            arr.add(num);
            set.add(num);
        }
        arr2 = new ArrayList<>(set);
        Collections.sort(arr2);
        for(int i = 0; i < arr2.size(); i++){
            ht.put(arr2.get(i), i);
        }
        for(int i = 0; i < arr.size(); i++){
            sb.append(ht.get(arr.get(i))).append(" ");
        }m
        System.out.println(sb);
    }
}
