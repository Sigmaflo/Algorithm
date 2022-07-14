import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int[] result;
    static int c = 1;
    static LinkedList<Integer> needVisit;

    public static void bfs(int curNode){
        needVisit = new LinkedList<>();
        visited[curNode] = true;
        result[curNode] = c;
        c++;
        needVisit.addAll(graph[curNode]);
        while(!needVisit.isEmpty()){
            int node = needVisit.remove(0);
            if(!visited[node]){
                visited[node] = true;
                result[node] = c;
                c++;
                needVisit.addAll(graph[node]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
       StringTokenizer st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());
       int R = Integer.parseInt(st.nextToken());
       visited = new boolean[N + 1];
       graph = new ArrayList[N + 1];
       result = new int[N + 1];
       for(int i = 0; i <= N; i++){
           visited[i] = false;
           graph[i] = new ArrayList<>();
           result[i] = 0;
       }
       for(int i = 0; i < M; i++){
           st = new StringTokenizer(br.readLine());
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           graph[a].add(b);
           graph[b].add(a);
       }
       for(int i = 0; i <= N; i++){
           Collections.sort(graph[i]);
       }
       bfs(R);
       for(int i = 1; i <= N; i++){
           sb.append(result[i]).append("\n");
       }
        System.out.println(sb);
    }
}
