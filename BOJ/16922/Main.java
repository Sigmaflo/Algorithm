import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static void input() {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        set = new HashSet<>();
    }

    static int N;
    static Set<Integer> set;
    static int[] nums = {1, 5, 10, 50};

    static void pro(int n) {
        for (int k = 0; k < 4; k++) {
            set.add(nums[k]);
        }
        if (n > 1) {
            for(int i = 1; i < n; i++) {
                Set<Integer> set2 = new HashSet<>();
                for (int num : set) {
                    for (int k = 0; k < 4; k++) {
                        set2.add(num + nums[k]);
                    }
                }
                set = set2;
            }
        }
        System.out.println(set.size());
    }

    public static void main(String[] args) {
        input();
        pro(N);
    }
}
