import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] A;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) A[i] = Integer.parseInt(st.nextToken());
    }

    static void pro() {
        int sum = 0, R = 0, ans = 0;
        for (int L = 1; L <= N; L++) {
            // L - 1 을 구간에서 제외하기
            sum -= A[L - 1];

            // 가능한 R 옮기기
            while(sum < M && R + 1 <= N) {
                R++;
                sum += A[R];
            }

            // 정답 갱신
            if (sum == M) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
