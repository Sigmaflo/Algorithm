import java.util.*;
import java.io.*;

public class Main {
    static int[][] board;

    static class Tomato{
        int x;
        int y;
        int day;

        public Tomato(int x, int y, int day){
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    private static int start(){
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<Tomato> queue = new LinkedList<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 1){
                    queue.offer(new Tomato(i, j, 0));
                }
            }
        }
        if(queue.size() == board.length * board[0].length){
            return 0;
        }
        int day = 0;
        while(!queue.isEmpty()){
            Tomato tomato = queue.poll();
            day = tomato.day;
            for(int i = 0; i < 4; i++){
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];
                if(nx >=0 && nx < board.length && ny >= 0 && ny < board[0].length){
                    if(board[nx][ny] == 0){
                        board[nx][ny] = 1;
                        queue.offer(new Tomato(nx, ny, day + 1));
                    }
                }
            }
        }
        if(checkTomato()){
            return day;
        }else{
            return -1;
        }
    }

    private static boolean checkTomato(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new int[m][n];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int day = start();
        bw.write(day+"");
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
