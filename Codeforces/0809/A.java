import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class A {
    static char[] text;
    static int n;
    static int m;

    public static void replace(int num){
        int a = num;
        int b = m + 1 - num;
        if(a <= b){
            if(text[a] == 'B'){
                text[a] = 'A';
                return;
            }
        }
        if(b < text.length){
            if(text[b] == 'B'){
                text[b] = 'A';
            }else{
                text[a] = 'A';
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for(int testcase = 0; testcase < t; testcase++){
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            text = new char[m+1];
            Arrays.fill(text, 'B');
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= n; i++){
                int a = Integer.parseInt(st.nextToken());
                replace(a);
            }
            for(int i = 1; i <= m; i++){
                sb.append(text[i]);
            }
            System.out.println(sb);
        }
    }
}
