import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Character,Double> ht = new HashMap<>();
        Stack<Double> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        String expression = br.readLine();
        for(int p = 65; p < 65 + n; p++){
            char alpha = (char)p;
            ht.put(alpha, Double.parseDouble(br.readLine()));
        }
        for(int k = 0; k < expression.length(); k++){
            char c = expression.charAt(k);
            if(c == '+'){
                double a = stack.pop();
                double b = stack.pop();
                stack.push(a+b);
            }else if(c == '-'){
                double a = stack.pop();
                double b = stack.pop();
                stack.push(b-a);
            }else if(c == '/'){
                double a = stack.pop();
                double b = stack.pop();
                stack.push(b/a);
            }else if(c == '*'){
                double a = stack.pop();
                double b = stack.pop();
                stack.push(a*b);
            }else{
                stack.push(ht.get(c));
            }
        }
        double result = stack.pop();
        bw.write(String.format("%.2f", result));
        bw.flush();
        bw.close();
    }
}
