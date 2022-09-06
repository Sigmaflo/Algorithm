import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, N, max;
    static String ans;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int tt = 0; tt < T; tt++) {
            N = Integer.parseInt(br.readLine());
            max = -1;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                int size = Integer.parseInt(st.nextToken());
                if (max < size) {
                    max = size;
                    ans = name;
                }
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb.toString());
    }
}
