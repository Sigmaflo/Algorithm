import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<String> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String[] command = br.readLine().split(" ");
            if(command[0].equals("push")){
                stack.push(command[1]);
            }else if(command[0].equals("pop")){
                if(stack.empty()){
                    bw.write("-1");
                }else{
                    bw.write(stack.pop());
                }
                bw.newLine();
            }else if(command[0].equals("size")){
                bw.write(Integer.toString(stack.size()));
                bw.newLine();
            }else if(command[0].equals("empty")){
                if(stack.empty()){
                    bw.write("1");
                }else{
                    bw.write("0");
                }
                bw.newLine();
            }else if(command[0].equals("top")){
                if(stack.empty()){
                    bw.write("-1");
                }else{
                    bw.write(stack.peek());
                }
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}
