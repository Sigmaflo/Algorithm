import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<String> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        String back = "";
        for(int i = 0; i < n; i++){
            String[] command = br.readLine().split(" ");
            if(command[0].equals("push")){
                queue.add(command[1]);
                back = command[1];
            }else if(command[0].equals("pop")){
                if(queue.isEmpty()){
                    bw.write("-1");
                }else{
                    bw.write(queue.poll());
                }
                bw.newLine();
            }else if(command[0].equals("size")){
                bw.write(Integer.toString(queue.size()));
                bw.newLine();
            }else if(command[0].equals("empty")){
                if(queue.isEmpty()){
                    bw.write("1");
                }else{
                    bw.write("0");
                }
                bw.newLine();
            }else if(command[0].equals("front")){
                if(queue.isEmpty()){
                    bw.write("-1");
                }else{
                    bw.write(queue.peek());
                }
                bw.newLine();
            }else if(command[0].equals("back")){
                if(queue.isEmpty()){
                    bw.write("-1");
                }else{
                    bw.write(back);
                }
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}
