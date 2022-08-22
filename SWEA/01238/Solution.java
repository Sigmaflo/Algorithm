import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer>[] adj;
    static int L, S, ans;

    static void input() throws IOException {
        adj = new ArrayList[101];
        for (int i = 1; i <= 100; i++) adj[i] = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
        }
    }

    static void pro() {
        int max_move = 0;
        int[] distance = new int[101];
        boolean[] visit = new boolean[101];
        Queue<Integer> Q = new LinkedList<>();
        Q.add(S);
        Q.add(0);
        visit[S] = true;
        while(!Q.isEmpty()) {
            int node = Q.poll(), move = Q.poll();
            distance[node] = move;
            max_move = Math.max(max_move, move);
            for (int next: adj[node]) {
                if(!visit[next]) {
                    visit[next] = true;
                    Q.add(next);
                    Q.add(move + 1);
                }
            }
        }
        for (int i = 100; i >= 0; i--) {
            if (distance[i] == max_move) {
                ans = i;
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        for (int tt = 1; tt <= 10; tt++) {
            input();
            pro();
            System.out.printf("#%d %d\n", tt, ans);
        }
    }
}
