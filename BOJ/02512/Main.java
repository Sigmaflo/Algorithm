import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] A;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
    }

    static boolean determination(int m) {
        int sum = 0;
        for (int i = 1; i <= N; i++) {
            if (A[i] >= m) {
                sum += m;
            } else {
                sum += A[i];
            }
        }
        return sum <= M;
    }

    static void pro() {
        int sum = 0, ans = 0;
        for (int i = 1; i <= N; i++) {
            sum += A[i];
        }
        if (sum > M) {
            int L = 1, R = 100000;
            while (L <= R) {
                int mid = (L + R) / 2;
                if (determination(mid)) {
                    ans = mid;
                    L = mid + 1;
                } else {
                    R = mid - 1;
                }
            }
        } else {
            for (int i = 1; i <= N; i++) {
                ans = Math.max(ans, A[i]);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
