import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static Queue<Integer> Q;
    static ArrayList<Integer>[] adj;
    static int[] indegre;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        indegre = new int[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            indegre[b]++;
        }
    }

    static void pro() {
        StringBuilder sb = new StringBuilder();
        Q = new LinkedList<Integer>();
        for (int i = 1; i <= N; i++) {
            if (indegre[i] == 0) Q.add(i);
        }
        while(!Q.isEmpty()) {
            int x = Q.poll();
            sb.append(x).append(" ");
            for (int y: adj[x]) {
                indegre[y]--;
                if (indegre[y] == 0) Q.add(y);
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
