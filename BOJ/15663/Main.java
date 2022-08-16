import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] nums;
    static int[] result;
    static boolean[] select;
    static Map<String, Boolean> ht;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        result = new int[M];
        select = new boolean[N];
        ht = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void rec_func(int k) {
        if (k == M) {
            StringBuilder str = new StringBuilder();
            for (int num : result) {
                str.append(num).append(" ");
            }
            if(ht.containsKey(str.toString())) return;
            ht.put(str.toString(), true);
            sb.append(str).append('\n');
            return;
        }
        for (int cand = 0; cand < N; cand++) {
            if(select[cand]) continue;
            select[cand] = true;
            result[k] = nums[cand];
            rec_func(k + 1);
            select[cand] = false;
        }
    }

    static void pro() {
        Arrays.sort(nums);
        rec_func(0);
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
