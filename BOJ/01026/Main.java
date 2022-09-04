import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        boolean[] used = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int max = Integer.MIN_VALUE;
            int max_idx = 0;
            for (int j = 0; j < N; j++) {
                if (used[j]) continue;
                if (B[j] > max) {
                    max = B[j];
                    max_idx = j;
                }
            }
            used[max_idx] = true;
            sum += A[i] * max;
        }
        System.out.println(sum);
    }
}
