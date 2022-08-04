import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int t = 1; t <= 10; t++){
            String T = br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < 8; i++){
                queue.add(Integer.parseInt(st.nextToken()));
            }
            int d = 1; //1 2 3 4 5
            while(true){
                int num = queue.poll();
                if(num - d <= 0){
                    queue.add(0);
                    break;
                }else{
                    num -= d;
                    queue.add(num);
                    d++;
                    if(d == 6){
                        d = 1;
                    }
                }
            }
            System.out.print("#"+t+" ");
            for(int num : queue){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}
