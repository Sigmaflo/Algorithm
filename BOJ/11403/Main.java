import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> graph;
    static int N;

    static int go(int a, int b){
        boolean[] visit = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(a);
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int node2 : graph.get(node)){
                if(!visit[node2]){
                    if(node2 == b){
                        return 1;
                    }
                    visit[node2] = true;
                    queue.add(node2);
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        graph = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            graph.add(new LinkedList<>());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int k = 0; k < N; k++){
                int node = Integer.parseInt(st.nextToken());
                if(node == 1){
                    graph.get(i).add(k);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(graph.get(i).size() > 0){
                    sb.append(go(i, j)).append(" ");
                }else{
                    sb.append(0).append(" ");
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
