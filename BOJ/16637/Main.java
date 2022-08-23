import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, ans;
    static ArrayList<Integer> nums;
    static ArrayList<Character> operator;
    static boolean[] select;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String line = br.readLine();
        nums = new ArrayList<>();
        operator = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if(Character.isDigit(line.charAt(i))) {
                nums.add(line.charAt(i)-'0');
            } else {
                operator.add(line.charAt(i));
            }
        }
    }

    static void calculation(ArrayList<Integer> priority) {
        boolean[] used = new boolean[operator.size()];
        ArrayList<Integer> temp_nums = new ArrayList<>(nums);
        for (int op_num: priority) {
            char op = operator.get(op_num);
            used[op_num] = true;
            if (op == '+') {
                int num = temp_nums.get(op_num) + temp_nums.get(op_num + 1);
                temp_nums.set(op_num, num);
                temp_nums.set(op_num + 1, num);
            } else if (op == '-') {
                int num = temp_nums.get(op_num) - temp_nums.get(op_num + 1);
                temp_nums.set(op_num, num);
                temp_nums.set(op_num + 1, num);
            } else if (op == '*') {
                int num = temp_nums.get(op_num) * temp_nums.get(op_num + 1);
                temp_nums.set(op_num, num);
                temp_nums.set(op_num + 1, num);
            }
        }
        int sum = temp_nums.get(0);
        for (int i = 0; i < operator.size(); i++) {
            if (used[i]) continue;
            char op = operator.get(i);
            if (op == '+') {
                sum += temp_nums.get(i + 1);
            } else if (op == '-') {
                sum -= temp_nums.get(i + 1);
            } else if (op == '*') {
                sum *= temp_nums.get(i + 1);
            }
        }
        ans = Math.max(ans, sum);
    }

    static void rec_func(int k, int sequence) {
        if (k == operator.size()) {
            ArrayList<Integer> priority = new ArrayList<>();
            for (int i = 0; i < operator.size(); i++) {
                if (select[i]) priority.add(i);
            }
            calculation(priority);
            return;
        }
        if (sequence == 0) {
            sequence++;
            select[k] = true;
            rec_func(k + 1, sequence);
        }
        sequence--;
        select[k] = false;
        rec_func(k + 1, sequence);
    }

    static void pro() {
        ans = Integer.MIN_VALUE;
        select = new boolean[N];
        rec_func(0, 0);
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        pro();
    }
}
