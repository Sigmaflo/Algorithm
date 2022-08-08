import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class State{
    int[] X;
    State(int[] _X){
        X = new int[3];
        for (int i=0;i<3;i++) X[i]= _X[i];
    }

    State move(int from, int to, int[] Limit){
        int[] nX = new int[]{X[0], X[1], X[2]};
        if (X[from] + X[to] >= Limit[to]) {
            nX[from] -= Limit[to] - X[to];
            nX[to] = Limit[to];
        } else{
            nX[to] += nX[from];
            nX[from] = 0;
        }
        return new State(nX);
    }
}

public class Main {
    static StringBuilder sb = new StringBuilder();

    static int[] limit;
    static boolean[] possible;
    static boolean[][][] visit;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        limit = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0;i<3;i++) limit[i] = Integer.parseInt(st.nextToken());
        visit = new boolean[205][205][205];
        possible = new boolean[205];
    }

    static void bfs(int x1, int x2, int x3){
        Queue<State> Q = new LinkedList<>();
        visit[x1][x2][x3] = true;
        Q.add(new State(new int[] {x1, x2, x3}));

        while(!Q.isEmpty()){
            State st = Q.poll();
            if(st.X[0] == 0) possible[st.X[2]] = true;
            for (int from=0;from<3;from++){
                for (int to=0;to<3;to++){
                    if (from == to) continue;
                    State nxt = st.move(from, to, limit);

                    if(!visit[nxt.X[0]][nxt.X[1]][nxt.X[2]]){
                        visit[nxt.X[0]][nxt.X[1]][nxt.X[2]] = true;
                        Q.add(nxt);
                    }
                }
            }
        }
    }

    static void pro(){
        bfs(0, 0, limit[2]);
        for (int i=0;i<=limit[2];i++){
           if(possible[i]) sb.append(i).append(' ');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}