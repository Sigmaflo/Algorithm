import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int node;
    int weight;

    public Edge (int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        if (this.weight > o.weight) {
            return  1;
        } else if (this.weight == o.weight) {
            return 0;
        }
        return -1;
    }
}

class Path {
    int node1;
    int node2;
    int weight;

    public Path(int node1, int node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }
}

public class Main {
    static HashMap<Integer, HashMap<Integer, Integer>> graph;
    static int V, E;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            if (graph.containsKey(A)) {
                graph.get(A).put(B, W);
            } else {
                HashMap<Integer, Integer> edge = new HashMap<>();
                edge.put(B, W);
                graph.put(A, edge);
            }
            if (graph.containsKey(B)) {
                graph.get(B).put(A, W);
            } else {
                HashMap<Integer, Integer> edge = new HashMap<>();
                edge.put(A, W);
                graph.put(B, edge);
            }
        }
    }

    static void prim(int startNode) {
        int totalWeight = 0;
        ArrayList<Path> mst = new ArrayList<>();
        PriorityQueue<Edge> keys = new PriorityQueue<>();
        HashMap<Integer, Edge> keysObjects = new HashMap<>();
        HashMap<Integer, Integer> pi = new HashMap<>();
        HashMap<Integer, Integer> linkedEdges;
        Edge edgeObject, poppedEdge, linkedEdge;

        for (int key : graph.keySet()) {
            if(key == startNode) {
                edgeObject = new Edge(key, 0);
                pi.put(key, key);
            } else {
                edgeObject = new Edge(key, Integer.MAX_VALUE);
                pi.put(key, null);
            }
            keys.add(edgeObject);
            keysObjects.put(key, edgeObject);
        }

        while (keys.size() > 0) {
            poppedEdge = keys.poll();
            keysObjects.remove(poppedEdge.node);

            mst.add(new Path(pi.get(poppedEdge.node), poppedEdge.node, poppedEdge.weight));
            totalWeight += poppedEdge.weight;

            linkedEdges = graph.get(poppedEdge.node);
            for (int adj : linkedEdges.keySet()) {
                if (keysObjects.containsKey(adj)) {
                    linkedEdge = keysObjects.get(adj);

                    if (linkedEdges.get(adj) < linkedEdge.weight) {
                        linkedEdge.weight = linkedEdges.get(adj);
                        pi.put(adj, poppedEdge.node);

                        keys.remove(linkedEdge);
                        keys.add(linkedEdge);
                    }
                }
            }
        }
        System.out.println(totalWeight);
    }

    public static void main(String[] args) throws IOException {
        input();
        prim(1);
    }
}
