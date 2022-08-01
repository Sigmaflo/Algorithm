import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= testcase; t++){
            String input = br.readLine();
            int[] first = new int[input.length()];
            int[] nums = new int[input.length()];
            for(int i = 0; i < input.length(); i++){
                nums[i] = Integer.parseInt(input.charAt(i)+"");
                first[i] = 0;
            }
            int count = 0;
            for(int i = 0; i < input.length(); i++){
                if(first[i] != nums[i]){
                    count++;
                    for(int j = i; j < input.length(); j++){
                        first[j] = nums[i];
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(count).append("\n");
        }
        System.out.println(sb);

    }
}
