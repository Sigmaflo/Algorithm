import java.util.Scanner;
class Solution
{
    public static int find_max_value(int[] aj, int[] bj){
        int step = 0;
        int max = Integer.MIN_VALUE;
        if(aj.length > bj.length){
            step = aj.length - bj.length;
            for(int i = 0; i <= step; i++){
                int sum = 0;
                for(int k = 0; k < bj.length; k++){
                    sum += bj[k] * aj[k+i];
                }
                if(sum > max){
                    max = sum;
                }
            }
        }else{
            step = bj.length - aj.length;
            for(int i = 0; i <= step; i++){
                int sum = 0;
                for(int k = 0; k < aj.length; k++){
                    sum += aj[k] * bj[k+i];
                }
                if(sum > max){
                    max = sum;
                }
            }
        }
        return max;
    }

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {

            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] aj = new int[n];
            int[] bj = new int[m];
            sc.nextLine();
            for(int k = 0; k < n; k++){
                aj[k] = sc.nextInt();
            }
            sc.nextLine();
            for(int k = 0; k < m; k++){
                bj[k] = sc.nextInt();
            }
            sc.nextLine();
            int max = find_max_value(aj, bj);
            System.out.print("#"+test_case+" ");
            System.out.println(max);
        }
    }
}