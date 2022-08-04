import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Solution {
    static HashMap<Character, Character> ht;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ht = new HashMap<>();
        ht.put('(',')');
        ht.put('[',']');
        ht.put('{','}');
        ht.put('<','>');
        for(int t = 1; t <= 10; t++){
            int vaild = 1;
            Stack<Character> stack = new Stack<>();
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            for(int i = 0; i < line.length(); i++){
                char c = line.charAt(i);
                if(c == '(' || c == '[' || c == '{' || c == '<'){
                    stack.push(c);
                }else if(c == ')' || c == ']' || c == '}' || c == '>'){
                    if(stack.isEmpty() || ht.get(stack.pop()) != c){
                        vaild = 0;
                        break;
                    }
                }
            }
            System.out.printf("#%d %d\n",t, vaild);
        }
    }
}
