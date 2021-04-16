import java.util.*;
import java.io.*;

public class Main {
    static int[][] board;
    static Queue<Cabbage> queue;

    static class Cabbage{
        int x;
        int y;

        public Cabbage(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    private static int get_earthworm(){
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        queue = new LinkedList<>();
        int earthworm = 0;
        while(!check_cabbage()){
            earthworm++;
            while(!queue.isEmpty()){
                Cabbage cabbage = queue.poll();
                board[cabbage.x][cabbage.y] = -1;
                for(int i = 0; i < 4; i++){
                    int nx = cabbage.x + dx[i];
                    int ny = cabbage.y + dy[i];
                    if(nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length){
                        if(board[nx][ny] == 1){
                            board[nx][ny] = -1;
                            queue.offer(new Cabbage(nx, ny));
                        }
                    }
                }
            }
        }
        return earthworm;
    }

    private static boolean check_cabbage(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 1){
                    queue.offer(new Cabbage(i, j));
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int u = 0; u < t; u++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            board = new int[m][n];
            for(int i = 0; i < board.length; i++){
                Arrays.fill(board[i], 0);
            }
            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                board[x][y] = 1;
            }
            int earthworn = get_earthworm();
            bw.write(earthworn+"");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
