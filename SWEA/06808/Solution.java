import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb;

    static void input() throws IOException {
        sb = new StringBuilder();
        aWin = 0;
        bWin = 0;
        nums1 = new int[10];
        nums2 = new int[10];
        used = new boolean[10];
        select = new int[10];
        int a = 1 , b = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] temp = new int[19];
        for( int i = 1; i < 19; i++ ) {
            temp[i] = i;
        }
        for (int i = 1; i <= 9; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums1[i] = num;
            temp[num] = 0;
        }
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j < 19; j++) {
                if (temp[j] != 0) {
                    nums2[i] = j;
                    temp[j] = 0;
                    break;
                }
            }
        }
        mid = 0;
        for(int i = 1; i < 19; i++) {
            mid += i;
        }
        mid /= 2;
    }

    static int[] nums1, nums2, select;
    static int aWin, bWin, mid;
    static boolean[] used;
    static void rec_func(int k) {
        if (k == 10) {
            int pointA = 0;
            int pointB = 0;
            for(int i = 1; i < 10; i++) {
                if(nums1[i] - select[i] > 0) {
                    pointA += nums1[i] + select[i];
                } else {
                    pointB += nums1[i] + select[i];
                }
            }
            if(pointA > pointB) {
                aWin++;
            } else {
                bWin++;
            }
        } else {
            for (int i = 1; i < 10; i++) {
                if(used[i]) continue;

                select[k] = nums2[i];
                used[i] = true;
                rec_func(k + 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            input();
            rec_func(1);
            sb.append("#").append(t).append(' ').append(aWin).append(' ').append(bWin);
            System.out.println(sb.toString());
        }
    }
}
