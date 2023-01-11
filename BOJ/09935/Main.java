import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Stack<Character> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String regex = br.readLine();
        int regexSize = regex.length();
        stack = new Stack<>();

        for(int i = 0; i < line.length(); i++) {
            stack.push(line.charAt(i));

            // 폭발 문자열과 길이가 같아지면 탐색 시작
            if(stack.size()>= regexSize) {
                boolean flag = true;
                // st.size-regexSize부터 ~ st.size까지 탐색하여 regex와 일치하면 제거
                for(int j = 0, index  = stack.size() - regexSize; j < regexSize; j++, index++) {
                    if(stack.get(index) != regex.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    for(int j=0; j<regexSize; j++) stack.pop();
                }
            }

        }
        for (int i = 0; i < stack.size(); i++) sb.append(stack.get(i));
        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());

    }
}
