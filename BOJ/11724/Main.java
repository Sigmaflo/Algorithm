import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;

    public static int findConnectedComponent(){
        int[] union = new int[N+1];
        for(int i = 0; i < union.length; i++){
            union[i] = -1;
        }
        int set = 1;
        int nodeCount = 1;
        int start = set;
        union[1] = set;
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(graph[start]);
        while(nodeCount != N){
            while(!queue.isEmpty()){
                int node = queue.poll();
                if(union[node] == -1){
                    union[node] = set;
                    nodeCount++;
                    queue.addAll(graph[node]);
                }
            }
            if(nodeCount == N){
                break;
            }else{
                set++;
            }
            for(int node = 1; node < union.length; node++){
                if(union[node] == -1){
                    union[node] = set;
                    nodeCount++;
                    queue.addAll(graph[node]);
                    break;
                }
            }
        }
        return set;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];
        for(int i = 0; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        int c = findConnectedComponent();
        System.out.println(c);
    }
}
