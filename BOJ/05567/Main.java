import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        visit = new boolean[n + 1];
        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
    }

    static void rec_func(int start) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);
        Q.add(0);
        visit[start] = true;
        while(!Q.isEmpty()) {
            int node = Q.poll(), move = Q.poll();
            if (move == 2) continue;
            for (int next: adj[node]) {
                if (visit[next]) continue;
                visit[next] = true;
                Q.add(next);
                Q.add(move + 1);
            }
        }
    }

    static void pro() {
        rec_func(1);
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            if (visit[i]) ans++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}