import java.util.*;
import java.io.*;

public class Main {
    static class People{
        int weight;
        int height;

        public People(String weight, String height){
            this.weight = Integer.parseInt(weight);
            this.height = Integer.parseInt(height);
        }

        public boolean compareTo(People o){
            return this.weight < o.weight && this.height < o.height;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<People> list = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i  = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            People people = new People(st.nextToken(), st.nextToken());
            list.add(people);
        }
        for(People people_a : list){
            int a_level = 1;
            for(People people_b : list){
                if(people_a.compareTo(people_b)){
                    a_level++;
                }
            }
            bw.write(a_level+" ");
        }
        bw.flush();
        bw.close();
    }
}
