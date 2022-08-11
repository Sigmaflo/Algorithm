import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] nums;
    static boolean[] select;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        nums = new int[9];
        select = new boolean[9];
        for (int i = 0; i < 9; i++) nums[i] = Integer.parseInt(br.readLine());
    }

    static void rec_func(int k, int cnt, int value) {
        if (cnt == 7) {
            if(value == 100) {
                for (int i = 0; i < 9; i++) {
                    if (select[i]) {
                        sb.append(nums[i]).append('\n');
                    }
                }
            }
            return;
        }
        if(k == 9) return;

        select[k] = true;
        rec_func(k + 1, cnt + 1, value + nums[k]);
        select[k] = false;
        rec_func(k + 1, cnt, value);
    }

    public static void main(String[] args) throws IOException {
        input();
        rec_func(0, 0, 0);
        System.out.println(sb.toString());
    }
}
