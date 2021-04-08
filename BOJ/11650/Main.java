import java.util.*;
import java.io.*;

public class Main {
    static class Dot implements Comparable<Dot> {
        int x;
        int y;

        public Dot(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int compareTo(Dot o){
            if(this.x != o.x){
                return this.x > o.x ? 1 : -1;
            }else if(this.y != o.y) {
                return this.y > o.y ? 1 : -1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Dot> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String[] d = br.readLine().split(" ");
            Dot dot = new Dot(Integer.parseInt(d[0]), Integer.parseInt(d[1]));
            list.add(dot);
        }
        Collections.sort(list);
        for(Dot dot : list){
            bw.write(dot.toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
