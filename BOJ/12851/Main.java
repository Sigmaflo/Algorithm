import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N, K;
    static int[] dist;
    static int[] dir = {2, -1, 1};
    static int count;

    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        K = scan.nextInt();
        dist = new int[100001];
    }

    static void bfs(int start) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);
        dist[start] = 0;
        count = 1;
        while(!Q.isEmpty()) {
            int cur = Q.poll();
            for (int k = 0; k < 3; k++) {
                int next;
                if (k == 0) {
                    next = cur * dir[k];
                } else {
                    next = cur + dir[k];
                }
                if (next < 0 || next > 100000) continue;
                if (next == K && dist[cur] + 1 == dist[next]) count++;
                if (dist[cur] + 1 > dist[next]) continue;
                dist[next] = dist[cur] + 1;
                Q.add(next);
            }
        }
    }

    static void pro() {
        Arrays.fill(dist, Integer.MAX_VALUE);
        bfs(N);
        System.out.println(dist[K]);
        System.out.println(count);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
