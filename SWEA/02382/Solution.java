import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m, k, ans;
    static ArrayList<Microbe> microbes;
    static int[][] dir = {{0, 0}, {-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // x 상 하 좌 우
    static int[][] A;

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        A = new int[n][n];
        microbes = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            A[x][y] = i+1;
            microbes.add(new Microbe(i+1, x, y, size, d));
        }
    }

    static class Microbe {
        int num, x, y, size, d;

        public Microbe(int num, int x, int y, int size, int d) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.size = size;
            this.d = d;
        }
    }

//    1. 미생물 군집이 이동한다.
//    약품칸에 도착하면 절반이 죽는다.
//    겹치는 경우 크기가 큰 군집에 합쳐진다.
    static void move() {
        int[][] new_A = new int[n][n];
        int[][] new_size = new int[n][n];
        for (int i = 0; i < microbes.size(); i++) {
            Microbe microbe = microbes.get(i);
            int nx = microbe.x + dir[microbe.d][0], ny = microbe.y + dir[microbe.d][1];
            microbe.x = nx;
            microbe.y = ny;
            if (nx == 0 || ny == 0 || nx == n - 1 || ny == n - 1) { // 약품칸에 도착하면
                int nsize = microbe.size / 2;
                if (nsize == 0) { // 군집 삭제
                    microbes.remove(i);
                    i--;
                    continue;
                }
                new_A[nx][ny] = microbe.num;
                microbe.size = nsize;
                // 1 -> 2
                // 2 -> 1
                // 3 -> 4
                // 4 -> 3
                if (microbe.d % 2 == 1) {
                    microbe.d++;
                } else {
                    microbe.d--;
                }
            } else { // 약품칸이 아니라면
                if (new_A[nx][ny] == 0) { // 빈칸일 때
                    new_A[nx][ny] = microbe.num;
                    new_size[nx][ny] = microbe.size;
                } else { // 군집이 있을 때
                    if (new_size[nx][ny] > microbe.size) { // 먹히는 경우
                        for (Microbe microbe1: microbes) {
                            if (microbe1.num == new_A[nx][ny]) {
                                microbe1.size += microbe.size;
                                microbes.remove(microbe);
                                i--;
                                break;
                            }
                        }
                    } else { // 잡아 먹는 경우
                        new_size[nx][ny] = microbe.size;
                        for (Microbe microbe1: microbes) {
                            if (microbe1.num == new_A[nx][ny]) {
                                microbe.size += microbe1.size;
                                new_A[nx][ny] = microbe.num;
                                microbes.remove(microbe1);
                                i--;
                                break;
                            }
                        }
                    }
                }
            }
        }
        A = new_A;
    }

    static int count() {
        int count = 0;
        for (Microbe microbe: microbes) {
            count += microbe.size;
        }
        return count;
    }

    static void pro() {
        ans = 0;
        int time = 0;
        while(time < m) {
            // 1. 미생물 군집이 이동한다. 약품칸에 도착하면 절반이 죽는다. 겹치는 경우 크기가 큰 군집에 합쳐진다.
            move();
            time++;
        }
        // 전체 미생물 수를 구한다.
        ans = count();
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            input();
            pro();
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }
}
