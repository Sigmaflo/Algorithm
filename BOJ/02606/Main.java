import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] network;
    static int V;

    public static int virus(int start){
        boolean[] visit = new boolean[V+1];
        for(int i = 0; i < visit.length; i++){
            visit[i] = false;
        }
        int count = 0;
        visit[start] = true;
        Queue<Integer> nodeList = new LinkedList<>();
        nodeList.addAll(network[start]);
        while(!nodeList.isEmpty()){
            int node = nodeList.poll();
            if(!visit[node]){
                visit[node] = true;
                count++;
                nodeList.addAll(network[node]);
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        network = new ArrayList[V+1];
        for(int i = 0; i <= V; i++){
            network[i] = new ArrayList<>();
        }
        for(int i = 0; i < E; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            network[a].add(b);
            network[b].add(a);
        }
        int computer = virus(1);
        System.out.println(computer);
    }
}
