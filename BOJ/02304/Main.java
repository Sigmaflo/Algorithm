import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Polygon implements Comparable<Polygon>{
        int x;
        int y;

        public Polygon(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Polygon o) {
            return this.x - o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] roof = new int[1001][1001];
        List<Polygon> list = new ArrayList<>();
        Polygon highestPolygon = new Polygon(0, 0);
        for(int t = 0; t < N; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            Polygon polygon = new Polygon(x, y);
            if(polygon.y > highestPolygon.y){
                highestPolygon = polygon;
            }
            list.add(polygon);
        }
        Collections.sort(list);
        for(Polygon polygon : list){
            if(polygon == highestPolygon){
                break;
            }
            for(int i = polygon.x; i < highestPolygon.x; i++){
                for(int j = 1; j <= polygon.y; j++){
                    roof[i][j] = 1;
                }
            }
        }
        for(int j = 1; j <= highestPolygon.y; j++){
            roof[highestPolygon.x][j] = 1;
        }
        for(int k = list.size()-1; k >=0; k--){
            Polygon polygon = list.get(k);
            if(polygon == highestPolygon){
                break;
            }
            for(int i = polygon.x; i > highestPolygon.x; i--){
                for(int j = 1; j <= polygon.y; j++){
                    roof[i][j] = 1;
                }
            }
        }
        int sum = 0;
        for(int i = 1; i < 1001; i++){
            for(int j = 1; j < 1001; j++){
                if(roof[i][j] == 1){
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}
