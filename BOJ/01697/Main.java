import java.util.*;
import java.io.*;

public class Main {
    static class Seek{
        int position;
        int time;

        public Seek(int position, int time){
            this.position = position;
            this.time = time;
        }
    }

    private static int hide_and_seek(int start, int end){
        Queue<Seek> queue = new LinkedList<>();
        Map<Integer, Integer> ht = new HashMap<>();
        if(start - end == 0){
            return 0;
        }
        int min_time = Integer.MAX_VALUE;
        queue.add(new Seek(start - 1, 1));
        queue.add(new Seek(start + 1, 1));
        queue.add(new Seek(start * 2, 1));
        ht.put(start - 1 , 1);
        ht.put(start + 1 , 1);
        ht.put(start * 2 , 1);
        while(!queue.isEmpty()){
            Seek seek = queue.poll();
            if(seek.position == end){
                min_time = Math.min(min_time, seek.time);
            }else{
                if(seek.position - 1 >= 0 && seek.position - 1 <= 100000){
                    if(ht.containsKey(seek.position - 1)){
                        if(ht.get(seek.position - 1) > seek.time + 1){
                            queue.offer(new Seek(seek.position - 1, seek.time + 1));
                            ht.put(seek.position - 1, seek.time + 1);
                        }
                    }else{
                        queue.offer(new Seek(seek.position - 1, seek.time + 1));
                        ht.put(seek.position - 1, seek.time + 1);
                    }
                }
                if(seek.position + 1 >= 0 && seek.position + 1 <= 100000){
                    if(ht.containsKey(seek.position + 1)){
                        if(ht.get(seek.position + 1) > seek.time + 1){
                            queue.offer(new Seek(seek.position + 1, seek.time + 1));
                            ht.put(seek.position + 1, seek.time + 1);
                        }
                    }else{
                        queue.offer(new Seek(seek.position + 1, seek.time + 1));
                        ht.put(seek.position + 1, seek.time + 1);
                    }
                }
                if(seek.position * 2 >= 0 && seek.position * 2 <= 100000){
                    if(ht.containsKey(seek.position * 2)){
                        if(ht.get(seek.position * 2) > seek.time + 1){
                            queue.offer(new Seek(seek.position * 2, seek.time + 1));
                            ht.put(seek.position * 2, seek.time + 1);
                        }
                    }else{
                        queue.offer(new Seek(seek.position * 2, seek.time + 1));
                        ht.put(seek.position * 2, seek.time + 1);
                    }
                }
            }
        }
        return min_time;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int time = hide_and_seek(n, k);
        bw.write(time+"");
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
