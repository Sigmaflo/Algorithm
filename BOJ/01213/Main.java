import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        ht = new HashMap<>();
        mid = line.length() / 2;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            set.add(c);
            if (!ht.containsKey(c)) {
                ht.put(c, 1);
            } else {
                ht.put(c, ht.get(c) + 1);
            }
        }
        alpha = new ArrayList<>(set);
        Collections.sort(alpha);
    }

    static List<Character> alpha;
    static Map<Character, Integer> ht;
    static int mid;

    static void pro() {
        int odd = 0;
        for (char c : alpha) if (ht.get(c) % 2 == 1) odd++;

        if (odd > 1) {
            sb.append("I'm Sorry Hansoo");
            return;
        }

        char odd_alpha = 'a';
        for (char c : alpha) if (ht.get(c) % 2 == 1) odd_alpha = c;

        for (char c : alpha) for (int i = 0; i < ht.get(c) / 2; i++) sb.append(c);

        if (odd_alpha != 'a') sb.append(odd_alpha);

        Collections.sort(alpha, Collections.reverseOrder());
        for (char c : alpha) for (int i = 0; i < ht.get(c) / 2; i++) sb.append(c);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
        System.out.println(sb.toString());
    }
}
