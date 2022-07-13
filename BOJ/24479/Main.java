import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
//    static ArrayList<Integer> needVisit;
    static ArrayList<Integer>[] graph;
    static int[] result;
    static int cx = 1;
    public static void dfs(int curNode){
        visited[curNode] = true;
        result[curNode] = cx;
        cx++;
        for(int i = 0; i < graph[curNode].size(); i++){
            int node = graph[curNode].get(i);
            if(!visited[node]){
                dfs(node);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        result = new int[N + 1];
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
        for(int i = 0; i <= N; i++){
            Collections.sort(graph[i]);
        }
        dfs(R);
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }
}
