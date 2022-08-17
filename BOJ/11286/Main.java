import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] cmds;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cmds = new int[N];
        for (int i = 0; i < N; i++) {
            cmds[i] = Integer.parseInt(br.readLine());
        }
    }

    static class NUM implements Comparable<NUM> {
        int num;

        public NUM(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(NUM o) {
            if (Math.abs(this.num) > Math.abs(o.num)) {
                return 1;
            } else if (Math.abs(this.num) == Math.abs(o.num)) {
                long n = (long) this.num * o.num;
                if (n < 0) {
                    if (this.num < 0) return -1;
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return -1;
            }
        }
    }

    static void pro() {
        PriorityQueue<NUM> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            if (cmds[i] != 0) {
                pq.add(new NUM(cmds[i]));
            } else {
                if (!pq.isEmpty()) {
                    sb.append(pq.poll().num).append('\n');
                } else {
                    sb.append('0').append('\n');
                }
            }
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}