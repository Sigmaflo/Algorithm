import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, count, ans;
    static boolean[] arr;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    static void calculation(boolean[] arr, int n) {
        for (int i = n; i < arr.length; i += n) {
            if (arr[i]) {
                count++;
                if (count == K) ans = i;
                arr[i] = false;
            }
        }
    }

    static void pro() {
        arr = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            arr[i] = true;
        }
        for (int i = 2; i <= N; i++) {
            if (arr[i]){
                calculation(arr, i);
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
