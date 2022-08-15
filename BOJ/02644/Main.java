import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, start, end, m, ans;
    static boolean[] visit;
    static ArrayList<Integer>[] adj;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        adj = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        ans = -1;
    }

    static void bfs() {
        Queue<Integer> Q = new LinkedList<>();
        visit[start] = true;
        for(int node : adj[start]) {
            visit[node] = true;
            Q.add(node);
            Q.add(1);
        }
        while(!Q.isEmpty()) {
            int node = Q.poll(), move = Q.poll();
            if (node == end) {
                ans = move;
                Q.clear();
                continue;
            }
            for (int next : adj[node]) {
                if (visit[next]) continue;
                visit[next] = true;
                Q.add(next);
                Q.add(move + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        bfs();
        System.out.println(ans);
    }
}
