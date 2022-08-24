import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static boolean exist;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
    }

    static void dfs(int node, int depth) {
        visit[node] = true;
        if (depth == 5) {
            exist = true;
            return;
        }
        for (int next: adj[node]) {
            if (!visit[next]) dfs(next, depth + 1);
        }
        visit[node] = false;
    }

    static void pro() {
        for (int node = 0; node < N; node++) {
            visit = new boolean[N];
            exist = false;
            dfs(node, 1);
            if (exist) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
