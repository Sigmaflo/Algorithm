import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[][] sum; // 부분합
    static char[] dna;
    static int[] dnaInput;
    static Map<Character, Integer> ht;
    int[] inputDna;

    public static void main(String[] args) throws IOException {
        dnaInput = new int[4];
        ht = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        dna = br.readLine().toCharArray();
        sum = new int[dna.length][];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            //요구하는 dna개수 저장
            dnaInput[i] = Integer.parseInt(st.nextToken());
        }// end input
        ht.put('A', 0);
        ht.put('C', 1);
        ht.put('G', 2);
        ht.put('T', 3);
        int[] subDna = new int[4];
        subDna[ht.get(dna[0])] += 1;
        sum[0] = subDna;
        for(int i = 1; i < dna.length; i++){
            //부분합 계산
            int[] prevDna = new int[4];
            System.arraycopy(sum[i - 1], 0, prevDna, 0, 4);
            prevDna[ht.get(dna[i])] += 1;
            sum[i] = prevDna;
        }
        int password = 0;
        for(int i = 0; i < dna.length-P+1; i++){
            //주어진 문자열 부분 문자열로 탐색
            if(isPassword(i, i+P-1)){
                password++;
            }
        }
        System.out.println(password);
    }

    static boolean isPassword(int a, int b){
        boolean available = true;
        int[] subDna = new int[4];
        if(a > 0){
            for(int i = 0; i < 4; i++){
                subDna[i] = sum[b][i] - sum[a-1][i];
            }
        }else{
            System.arraycopy(sum[b], 0, subDna, 0, 4);
        }

        for(int i =0 ; i < 4; i++){
            if(subDna[i] - dnaInput[i] < 0){
                available = false;
                break;
            }
        }
        return  available;
    }
}
