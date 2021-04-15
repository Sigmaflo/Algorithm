import java.util.*;
import java.io.*;

public class Main {
    private static int set_ground(int[][] ground, int max, int bag){
        int time = 0;
        for(int i = 0; i < ground.length; i++){
            for(int j = 0; j < ground[i].length; j++){
                if(ground[i][j] > max){
                    int d =  ground[i][j] - max;
                    bag += d;
                    time += d * 2;
                }else if(ground[i][j] < max){
                    int d = max - ground[i][j];
                    time += d;
                    bag -= d;
                }
            }
        }
        return bag < 0 ? Integer.MAX_VALUE : time;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[][] ground = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                ground[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int min_time = Integer.MAX_VALUE;
        int max_height = 0;
        for(int height = 0; height <= 256; height++){
            int time = set_ground(ground, height, b);
            if(time < min_time){
                min_time = time;
                max_height = height;
            }else if(time == min_time){
                if(height > max_height){
                    max_height = height;
                }
            }
        }
        bw.write(min_time + " " + max_height);
        bw.flush();
        bw.close();
    }
}
