import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder sb;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    static void input() throws IOException {
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nums = new LinkedList<>();
        for(int i = 0; i < N; i++){
            nums.add(Integer.parseInt(st.nextToken()));
        }
        M = Integer.parseInt(br.readLine());
    }

    static int N, M;
    static List<Integer> nums;

    static void func() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            String cmd = st.nextToken();
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int cand = 0; cand < y; cand++){
                nums.add(x, Integer.parseInt(st.nextToken()));
                x++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        for(int t = 1; t <= 10; t++){
            input();
            func();
            sb.append("#").append(t).append(' ');
            for(int i = 0; i < 10; i++){
                sb.append(nums.get(i)).append(' ');
            }
            System.out.println(sb.toString());
        }
    }
}
