import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int[][] visit;
    static int N, M, count=Integer.MAX_VALUE, endX, endY;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class Dot{
        int x;
        int y;
        int move;
        int wall;

        public Dot(int x, int y, int move, int wall){
            this.x = x;
            this.y = y;
            this.move = move;
            this.wall = wall;
        }
    }

    static void bfs(){
        if(endX== 0 && endY == 0){
            count = 1;
            return;
        }
        Queue<Dot> queue = new LinkedList<>();
        queue.add(new Dot(0, 0, 1, 0));
        visit[0][0] = 2;
        while(!queue.isEmpty()){
            Dot dot = queue.poll();
            if(dot.x == endX && dot.y == endY){
                count = Math.min(count, dot.move);
                continue;
            }
            for(int i = 0; i < 4; i++){
                int nextX = dot.x + dx[i];
                int nextY = dot.y + dy[i];
                if(nextX >= 0 && nextX < N && nextY >=0 && nextY < M && visit[nextX][nextY] < 2){
                    if(board[nextX][nextY] == 0 && dot.wall == 0) { // 벽을 부신 적이 없음
                        visit[nextX][nextY] = 2;
                        queue.add(new Dot(nextX, nextY, dot.move + 1, dot.wall));
                    }else if(board[nextX][nextY] == 0 && dot.wall == 1 && visit[nextX][nextY] == 0){ // 벽을 분신 적이 있음
                        visit[nextX][nextY] = 1;
                        queue.add(new Dot(nextX, nextY, dot.move + 1, dot.wall));
                    }else if(board[nextX][nextY] == 1 && dot.wall == 0){ // 벽을 부심
                        visit[nextX][nextY] = 2;
                        queue.add(new Dot(nextX, nextY, dot.move + 1, dot.wall + 1));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                board[i][j] = line.charAt(j)-'0';
            }
        }
        visit = new int[N][M];
        endX = N - 1;
        endY = M - 1;
        bfs();
        if(count == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(count);
        }
    }
}
