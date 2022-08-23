import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;
    static int n, m;
    static int[] parent, rank;
    static int[][] cmds;
    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) parent[i] = i;
        rank = new int[n + 1];
        cmds = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            cmds[i][0] = Integer.parseInt(st.nextToken());
            cmds[i][1] = Integer.parseInt(st.nextToken());
            cmds[i][2] = Integer.parseInt(st.nextToken());
        }
    }

    static int find(int node) {
        // path compression 기법
        if (parent[node] != node) {
            parent[node] = find(parent[node]);
        }
        return parent[node];
    }

    static void union(int nodeV, int nodeU) {
        int root1 = find(nodeV);
        int root2 = find(nodeU);

        // union-by-rank 기법
        if (rank[root1] > rank[root2]) {
            parent[root2] = root1;
        } else {
            parent[root1] = root2;
            if (rank[root1] == rank[root2]) {
                rank[root2] = rank[root2] + 1;
            }
        }
    }

    static void pro(int tt) {
        sb = new StringBuilder();
        sb.append('#').append(tt).append(' ');
        for (int[] cmd: cmds) {
            if(cmd[0] == 0) {
                union(cmd[1], cmd[2]);
            } else { // cmd[0] == 1
                if (find(cmd[1]) == find(cmd[2])) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= T; tt++) {
            input();
            pro(tt);
        }
    }
}
