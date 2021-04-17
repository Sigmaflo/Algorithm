import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> inP = new HashMap<>();
        inP.put('(', 0);
        inP.put('+', 1);
        inP.put('-', 1);
        inP.put('*', 2);
        inP.put('/', 2);
        Map<Character, Integer> outP = new HashMap<>();
        outP.put('+', 1);
        outP.put('-', 1);
        outP.put('*', 2);
        outP.put('/', 2);
        outP.put('(', 3);
        StringBuilder postfix = new StringBuilder();
        String infix = scan.nextLine();
        for(int i = 0; i < infix.length(); i++){
            char token = infix.charAt(i);
            if(token == '(' || token == '+' || token == '-' || token == '*' || token == '/'){
                if(stack.isEmpty()){
                    stack.push(token);
                }else{
                    if(inP.get(stack.peek()) < outP.get(token)){
                        stack.push(token);
                    }else{
                        while(true){
                            if(inP.get(stack.peek()) < outP.get(token)){
                                stack.push(token);
                                break;
                            }
                            postfix.append(stack.pop());
                        }
                    }
                }
            }else if(token == ')'){
                while(true){
                    if(stack.peek() == '('){
                        stack.pop();
                        break;
                    }
                    postfix.append(stack.pop());
                }
            }else{
                postfix.append(token);
            }
            if(i + 1 == infix.length()){
                while (!stack.isEmpty()) {
                    postfix.append(stack.pop());
                }
            }
        }
        System.out.println(postfix.toString());
    }
}
