import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int testcase = 1; testcase <= t; testcase++){
            int N = scan.nextInt();
            int[][] board = new int[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    board[i][j] = scan.nextInt();
                }
            }
            System.out.println("#" + testcase);

            for (int i = 0; i < N; i++){
                //90도
                for (int j = 0; j < N; j++) {
                    System.out.print(board[N - 1 - j][i]);
                }
                System.out.print(" ");

                //180도
                for (int j = 0; j < N; j++) {
                    System.out.print(board[N - 1 - i][N - 1 - j]);
                }
                System.out.print(" ");

                //270도 = 왼쪽90도
                for (int j = 0; j < N; j++) {
                    System.out.print(board[j][N - 1 - i]);
                }
                System.out.println();
            }
        }
    }
}
