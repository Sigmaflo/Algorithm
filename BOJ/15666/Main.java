import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] nums;
    static int[] result;
    static Map<String, Integer> ht;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        result = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void rec_func(int k, int start) {
        if (k == M) {
            StringBuilder sub = new StringBuilder();
            for (int i = 0; i < M; i++) sub.append(result[i]).append(' ');
            if (ht.containsKey(sub.toString())) {
                return;
            } else {
                ht.put(sub.toString(), 1);
                sb.append(sub.toString());
                sb.append('\n');
            }
            return;
        }
        for (int i = start; i < N; i++) {
            result[k] = nums[i];
            rec_func(k + 1,  i);
        }
    }

    static void pro() {
        ht = new HashMap<>();
        Arrays.sort(nums);
        rec_func(0, 0);
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
