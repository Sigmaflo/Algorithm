import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][][] tomatoes;
    static int M;
    static int N;
    static int H;

    static class Tomato{
        int x;
        int y;
        int h;
        int day;

        public Tomato(int h, int y, int x, int day){
            this.h = h;
            this.y = y;
            this.x = x;
            this.day = day;
        }
    }

    public static boolean isAllRipening(){
        for(int h = 0; h < H; h++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(tomatoes[h][i][j] == 0){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static int tomato(){
        int[] nh = {0, 0, 0, 0, 1, -1};
        int[] nx = {1, -1, 0, 0, 0, 0};
        int[] ny = {0, 0, 1, -1, 0, 0};
        Queue<Tomato> queue = new LinkedList<>();
        for(int h = 0; h < H; h++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(tomatoes[h][i][j] == 1){
                        queue.add(new Tomato(h, i, j, 0));
                    }
                }
            }
        }
        if(queue.size() == N * M * H){
            return 0;
        }
        int day = 0;
        while (!queue.isEmpty()){
            Tomato toamto = queue.poll();
            day = toamto.day;
            for(int i = 0; i < 6; i++){
                int h = toamto.h + nh[i];
                int y = toamto.y + ny[i];
                int x = toamto.x + nx[i];
                if(x >= 0 && x < M && y >=0 && y < N && h >=0 && h < H){
                    if(tomatoes[h][y][x] == 0){
                        tomatoes[h][y][x] = 1;
                        queue.add(new Tomato(h, y, x, day + 1));
                    }
                }
            }
        }
        if(isAllRipening()){
            return day;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        tomatoes = new int[H][N][M];
        for(int h = 0; h < H; h++){
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++){
                    tomatoes[h][i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
        int day = tomato();
        System.out.println(day);
    }
}
