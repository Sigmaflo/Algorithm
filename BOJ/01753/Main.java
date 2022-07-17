import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashMap<Integer, ArrayList<Edge>> graph;
    static int V;
    static HashMap<Integer, Integer> distances;

    public static void dijkstraFunc(int start){
        Edge edgeNode, adjacentNode;
        ArrayList<Edge> nodeList;
        int currentDistance, weight, distance;
        int currentNode, adjacent;

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        distances = new HashMap<>();

        for(int i = 1; i <= V; i++){//Edge가 없는 노드 포함
            distances.put(i, Integer.MAX_VALUE);
        }
        distances.put(start, 0);

        priorityQueue.add(new Edge(distances.get(start), start));

        while(!priorityQueue.isEmpty()){
            edgeNode = priorityQueue.poll();
            currentDistance = edgeNode.weight;
            currentNode = edgeNode.vertex;

            if(distances.get(currentNode) < currentDistance){
                continue;
            }

            if(graph.containsKey(currentNode)){//curretNode가 Edge가 있을때
                nodeList = graph.get(currentNode);
                for(int index = 0; index < nodeList.size(); index++){
                    adjacentNode = nodeList.get(index);
                    adjacent = adjacentNode.vertex;
                    weight = adjacentNode.weight;
                    distance = currentDistance + weight;

                    if(distance < distances.get(adjacent)){
                        distances.put(adjacent, distance);
                        priorityQueue.add(new Edge(distance, adjacent));
                    }
                }
            }

        }
    }
    static class Edge implements Comparable<Edge>{
        public int weight;
        public int vertex;

        public Edge(int weight, int vertex){
            this.weight = weight;
            this.vertex = vertex;
        }

        @Override
        public int compareTo(Edge edge){
            return this.weight - edge.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        graph = new HashMap<>();
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if(!graph.containsKey(a)){
                graph.put(a, new ArrayList<Edge>(List.of(new Edge(weight, b))));
            }else{
                graph.get(a).add(new Edge(weight, b));
            }
        }
        dijkstraFunc(start);
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= V; i++){
            if(distances.get(i) == Integer.MAX_VALUE){
                sb.append("INF").append("\n");
            }else{
                sb.append(distances.get(i)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
