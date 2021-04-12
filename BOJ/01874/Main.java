import java.util.*;
import java.io.*;

public class Main {
    static int[] input_list;
    static List<Integer> r_list;
    static Stack<Integer> stack;
    static StringBuilder sb;
    static int k;

    private static boolean is_available(){
        if(input_list.length != r_list.size()+1){
            return false;
        }
        for(int i = 1; i < input_list.length; i++){
            if(input_list[i] != r_list.get(i-1)){
                return false;
            }
        }
        return true;
    }

    private static void push(int num){
        stack.push(num);
        sb.append("+").append("\n");
    }

    private static void pop(){
        r_list.add(stack.pop());
        sb.append("-").append("\n");
        k++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        input_list = new int[n+1];
        r_list = new ArrayList<>();
        stack = new Stack<>();
        for(int i = 1; i <= n; i++){
            input_list[i] = Integer.parseInt(br.readLine());
        }
        k = 1;
        for(int num = 1; num <= n; num++){
            if(num == input_list[k]){
                push(num);
                while(!stack.isEmpty() && stack.peek() == input_list[k]){
                    pop();
                }
            }else{
                push(num);
            }
        }
        if(is_available()){
            bw.write(sb.toString());
        }else{
            bw.write("NO");
        }
        bw.flush();
        bw.close();
    }
}
