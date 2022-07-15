import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static HashMap<Integer, ArrayList<Edge>> graph;
    static int N;

    public static int dijkstraFunc(int start, int end){
        Edge edgeNode, adjacentNode;
        ArrayList<Edge> nodeList;
        int currentDistance, weight, distance;
        int currentNode, adjacent;

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        HashMap<Integer, Integer> distances = new HashMap<>();

        for(int i = 1; i <= N; i++){//Edge가 없는 노드 포함
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
        return distances.get(end);
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
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        graph = new HashMap<>();
        for(int i = 0; i < M; i++){
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
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int d = dijkstraFunc(start, end);
        System.out.println(d);
    }
}
