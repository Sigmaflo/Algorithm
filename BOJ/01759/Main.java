import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        alpha = new char[C + 1];
        used = new boolean[C + 1];
        result = new char[L + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= C; i++){
            alpha[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alpha);
    }

    static int L, C;
    static char[] alpha;
    static boolean[] used;
    static char[] result;
    static char[] consonant = {'a', 'e', 'i', 'o', 'u'};

    static int count_consonant(char[] arr) {
        int count = 0;
        for(int i=1;i<arr.length;i++)
            for(int j=0;j<5;j++)
                if(consonant[j] == arr[i])
                    count++;
        return count;
    }

    static void rec_func(int k, int idx) {
       if(k == L + 1) {
            int count1 = count_consonant(result);
            if(count1 > 0 && count1 < L - 1) {
                for (int i = 1; i <= L; i++) sb.append(result[i]);
                sb.append('\n');
            }
       } else {
           for (int i = idx; i <= C; i++) {
               if(used[i]) continue;
               used[i] = true;
               result[k] = alpha[i];
               rec_func(k + 1, i + 1);
               used[i] = false;
               result[k] = 0;
           }
       }
    }

    public static void main(String[] args) throws IOException {
        input();
        rec_func(1, 1);
        System.out.print(sb.toString());
    }
}
