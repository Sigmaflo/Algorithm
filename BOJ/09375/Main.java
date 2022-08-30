import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T, N, ans;
    static HashMap<String, Integer> ht;

    static void input() throws IOException {
        ht = new HashMap<>();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String sort = st.nextToken();
            if (!ht.containsKey(sort)) {
                ht.put(sort, 1);
            } else {
                ht.put(sort, ht.get(sort) + 1);
            }
        }
    }

    static void pro() {
        ans = 1;
        for (int num : ht.values()) {
            ans *= (num + 1);
        }
        System.out.println(ans - 1);
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            input();
            pro();
        }
    }
}
