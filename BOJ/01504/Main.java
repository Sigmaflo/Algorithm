import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, E, v1, v2;
    static List<Edge>[] adj;
    static int[] dist;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adj[a].add(new Edge(b, weight));
            adj[b].add(new Edge(a, weight));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
    }

    static class Edge implements Comparable<Edge>{
        int n,weight;

        public Edge(int n, int weight) {
            this.n = n;
            this.weight = weight;
        }


        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static long dijkstra(int start, int end) {
        dist = new int[N + 1];
        for (int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (dist[edge.n] < edge.weight) continue;

            for (Edge next_edge: adj[edge.n]) {
                if (dist[edge.n] + next_edge.weight >= dist[next_edge.n]) continue;
                dist[next_edge.n] = dist[edge.n] + next_edge.weight;
                pq.add(new Edge(next_edge.n, dist[next_edge.n]));
            }
        }

        return dist[end];
    }

    static void pro() {
        // 1 - > v1 -> v2 -> n
        long ans1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);

        // 1 -> v2 -> v1 -> n
        long ans2 =  dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

        if (ans1 >= Integer.MAX_VALUE && ans2 >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(ans1, ans2));
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
