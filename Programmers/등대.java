import java.util.ArrayList;

class Solution {
    
    static int N, answer;
    static ArrayList<Integer>[] adj;
    static boolean[] visited, light;
    
    static void dfs(int x) {
        visited[x] = true;
        
        for(int y: adj[x]) {
            if (visited[y]) continue;
            visited[y] = true;
            dfs(y);
            if (!light[y]) light[x] = true;
        }
    }
    
    static void pro() {
        dfs(1);
        for (int i = 1; i <= N; i++) {
            if (light[i]) answer++;
        }
    }
    
    
    public int solution(int n, int[][] lighthouse) {
        N = n;
        adj = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        light =  new boolean[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < lighthouse.length; i++) {
            adj[lighthouse[i][0]].add(lighthouse[i][1]);
            adj[lighthouse[i][1]].add(lighthouse[i][0]);
        }
        pro();
        
        return answer;
    }
}
