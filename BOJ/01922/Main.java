import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static class Edge implements Comparable<Edge>{
        public int weight;
        public int nodeV;
        public int nodeU;

        public Edge(int weight, int nodeV, int nodeU){
            this.weight = weight;
            this.nodeV = nodeV;
            this.nodeU = nodeU;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    public static int find(int node){
        if(parent.get(node) != node){
            parent.set(node, find(parent.get(node)));
        }
        return parent.get(node);
    }

    public static void union(int nodeV, int nodeU){
        int root1 = find(nodeV);
        int root2 = find(nodeU);

        if(rank.get(root1) > rank.get(root2)){
            parent.set(root2, root1);
        }else{
            parent.set(root1, root2);
            if(rank.get(root1) == rank.get(root2)){
                rank.set(root2, rank.get(root2) + 1);
            }
        }
    }

    public static int kruskalFunc(){
        ArrayList<Edge> mst = new ArrayList<>();
        Edge currentNode;

        for(int i = 0; i <= V; i++){
            parent.add(i);
            rank.add(0);
        }

        Collections.sort(edges);

        for(Edge edge : edges){
            currentNode = edge;
            if(find(currentNode.nodeV) != find(currentNode.nodeU)){
                union(currentNode.nodeV, currentNode.nodeU);
                mst.add(currentNode);
            }
        }

        int sum = 0;
        for(Edge edge : mst){
            sum += edge.weight;
        }

        return sum;
    }

    static ArrayList<Edge> edges = new ArrayList<>();
    static int V, E;
    static ArrayList<Integer> parent = new ArrayList<>();
    static ArrayList<Integer> rank = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        for(int i = 0; i < E; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeV = Integer.parseInt(st.nextToken());
            int nodeU = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges.add(new Edge(weight, nodeV, nodeU));
        }
        int result = kruskalFunc();
        System.out.println(result);
    }
}
