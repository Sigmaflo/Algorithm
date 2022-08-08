import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Q = new LinkedList<>();
        for (int i = 1; i <= N; i++) Q.add(i);
    }

    static int N, K;
    static Queue<Integer> Q;

    static void pro() {
        sb.append('<');
        for (int i = 0; i < N - 1; i++) {
            for( int k = 0; k < K - 1; k++) {
                int poppedNum = Q.poll();
                Q.add(poppedNum);
            }
            sb.append(Q.poll()).append(", ");
        }
        sb.append(Q.poll()).append('>');
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
        System.out.println(sb.toString());
    }
}
