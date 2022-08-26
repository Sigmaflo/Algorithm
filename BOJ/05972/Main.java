import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static ArrayList<Edge>[] adj;
    static boolean[] visited;
    static int[] dist;

    static class Edge {
        int vertex, weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        dist = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adj[a].add(new Edge(b, w));
            adj[b].add(new Edge(a, w));
        }
    }

    public static void dijkstra(int k) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.weight));
        dist[k] = 0;
        pq.offer(new Edge(k, 0));

        while(!pq.isEmpty()) {
            Edge current = pq.poll();

            if (visited[current.vertex]) continue;
            visited[current.vertex] = true;

            for(int i = 0; i < adj[current.vertex].size(); i++) {
                Edge next = adj[current.vertex].get(i);
                if(dist[next.vertex] > dist[current.vertex] + next.weight) {
                    dist[next.vertex] = dist[current.vertex] + next.weight;
                    pq.offer(new Edge(next.vertex, dist[next.vertex]));
                }
            }
        }
        System.out.println(dist[N]);
    }

    public static void main(String[] args) throws IOException {
        input();
        dijkstra(1);
    }
}
