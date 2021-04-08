import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        boolean b = false;
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int k = 0; k < line.length(); k++){
                char c = line.charAt(k);
                if(c == '('){
                    stack.push(c);
                }else if(c == ')'){
                    if(stack.isEmpty()){
                        b = true;
                        break;
                    }else{
                        stack.pop();
                    }
                }
            }
            if(!b && stack.isEmpty()){
                bw.write("YES");
            }else{
                bw.write("NO");
            }
            bw.newLine();
            b = false;
            stack.clear();
        }
        bw.flush();
        bw.close();
    }
}
