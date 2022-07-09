import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int testcase = 1; testcase <= t; testcase++){
            int N = scan.nextInt();
            int M = scan.nextInt();
            int[][] board = new int[N][N];
            for(int u = 0; u < N; u++){
                for(int j = 0; j < N; j++){
                    board[u][j] = scan.nextInt();
                }
            }
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for(int k = 0; k< board.length; k++){
                for(int j = 0; j < board[k].length; j++){
                    if(k + M - 1 < board.length && j + M -1 < board[k].length){
                        for(int step1 = 0; step1 < M; step1++) {
                            int length = j + step1;
                            for (int step2 = 0; step2 < M; step2++) {
                                int width = k + step2;
                                sum += board[width][length];
                            }
                        }
                        if(max < sum){
                            max = sum;
                        }
                        sum = 0;
                    }
                }
            }
            System.out.printf("#%d %d\n", testcase, max);
        }
    }
}
