import javax.swing.plaf.SliderUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        HashMap<Character, Integer> ht = new HashMap<>();
        ht.put('a', 1);
        ht.put('A', 1);
        ht.put('e', 1);
        ht.put('E', 1);
        ht.put('i', 1);
        ht.put('I', 1);
        ht.put('o', 1);
        ht.put('O', 1);
        ht.put('u', 1);
        ht.put('U', 1);
        while (!line.equals("#")) {
            int n = 0;
            for (int i = 0; i < line.length(); i++) {
                if (ht.containsKey(line.charAt(i))) n++;
            }
            sb.append(n).append('\n');
            line = br.readLine();
        }
        System.out.print(sb.toString());
    }
}
