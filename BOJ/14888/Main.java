import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N + 1];
        operators = new int[5];
        order = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) nums[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= 4; i++) operators[i] = Integer.parseInt(st.nextToken());

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    static int N, max, min;
    static int[] nums, operators, order;

    // 완성된 식에 맞게 계산을 해서 정답에 갱신하는 작업
    static int calculator(){
        // nums, order
        int value = nums[1];
        for (int i=1;i<=N-1;i++){
            //value, order[i], num[i+1]
            if(order[i] == 1)
                value = value + nums[i+1];
            if(order[i] == 2)
                value = value - nums[i+1];
            if(order[i] == 3)
                value = value * nums[i+1];
            if(order[i] == 4)
                value = value / nums[i+1];
        }
        return value;
    }

    // order[1...N-1] 에 연산자들이 순서대로 저장될 것이다
    static void rec_func(int k){
        if(k == N){ // 모든 연산자들을 전부 나열하는 방법을 찾은 상태
            // 정한 연산자 순서대로 계산해서 정답을 갱신하기
            int value = calculator();
            max = Math.max(max, value);
            min = Math.min(min, value);
        }else{ // k번째 연산자는 무엇을 선택할 것인가?
            // 4가지의 연산자들 중에 뭘 쓸것인지 선택하고 재귀호출하기
            for (int cand = 1; cand <= 4; cand++){
                if(operators[cand] >= 1){
                    operators[cand]--;
                    order[k] = cand;
                    rec_func(k+1);
                    operators[cand]++;
                    order[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        rec_func(1);
        sb.append(max).append('\n').append(min);
        System.out.println(sb.toString());;
    }
}