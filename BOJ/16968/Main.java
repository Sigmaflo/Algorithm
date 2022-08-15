import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[] nums, alpha, result;
    static String format;
    static int ans;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        format = br.readLine();
        result = new char[format.length()];
        nums = new char[10];
        for (int i = 0; i < 10; i++) {
            nums[i] = (char)(i + '0');
        }
        alpha = new char[26];
        for (int i = 0; i < 26; i++) {
            alpha[i] = (char)(i + 'a');
        }
    }

    static void rec_func(int k) {
        if (k == format.length()) {
            for (int i = 0; i < format.length() - 1; i++) {
                if (result[i] == result[i + 1]) return;
            }
            ans++;
            return;
        }
        if(format.charAt(k) == 'd') {
            for (int i = 0; i < 10; i++) {
                result[k] = nums[i];
                rec_func(k + 1);
            }
        } else if(format.charAt(k) == 'c') {
            for (int i = 0; i < 26; i++) {
                result[k] = alpha[i];
                rec_func(k + 1);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        input();
        rec_func(0);
        System.out.println(ans);
    }
}
