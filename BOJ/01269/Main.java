import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Character> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            set.add(st.nextToken().charAt(0));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            char num = st.nextToken().charAt(0);
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }
        System.out.println(set.size());
    }
}
