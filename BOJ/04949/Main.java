import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        while(!line.equals(".")){
            Stack<Character> stack = new Stack<>();
            boolean is_balance = true;
            for(int i = 0; i < line.length(); i++){
                char c = line.charAt(i);
                if(c == '(' || c == '['){
                    stack.push(c);
                }else if(c == ')'){
                    if(!stack.isEmpty()){
                        if(stack.peek() == '('){
                            stack.pop();
                        }else{
                            is_balance = false;
                        }
                    } else{
                        is_balance = false;
                    }
                }else if(c == ']'){
                    if(!stack.isEmpty()){
                        if(stack.peek() == '['){
                            stack.pop();
                        }else{
                            is_balance = false;
                        }
                    }else{
                        is_balance = false;
                    }
                }
                if(!is_balance){
                    break;
                }
            }
            if(is_balance && stack.isEmpty()){
                bw.write("yes");
            } else{
                bw.write("no");
            }
            bw.newLine();
            line = br.readLine();
        }
        bw.flush();
        bw.close();
    }
}
