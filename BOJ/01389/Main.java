import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashMap<Integer, LinkedList<Integer>> graph;
    static int[] kevinBaconList;
    static int N;

    static void search(int n){
        int[] distances = new int[N+1];
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(distances, Integer.MAX_VALUE);
        queue.add(n);
        distances[n] = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            int distance = distances[cur];
            for(int ad : graph.get(cur)){
                if(distances[ad] > distance + 1){
                    distances[ad] = distance + 1;
                    queue.add(ad);
                }
            }
        }
        int sum = 0;
        for(int i = 1; i <= N; i++){
            sum += distances[i];
        }
        kevinBaconList[n] = sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        kevinBaconList = new int[N+1];
        for(int i = 1; i <= N; i++){
            graph.put(i, new LinkedList<Integer>());
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for(int i = 1; i <= N; i++){
            search(i);
        }
        int chairman = 0;
        int min = 101;
        for(int i = 1; i <= N; i++){
            if(kevinBaconList[i] < min){
                min = kevinBaconList[i];
                chairman = i;
            }
        }
        System.out.println(chairman);
    }
}
