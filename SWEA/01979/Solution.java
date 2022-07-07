import java.util.Scanner;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        int T;
        T=scan.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = scan.nextInt();
            int K = scan.nextInt();
//            scan.nextLine();

            int[][] board = new int[N][N];
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    board[i][j] = scan.nextInt();
                }
            }
            int count = 0;
            int sum = 0;
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    if(board[i][j] == 1){
                        sum++;
                    }else{
                        if(sum == K){
                            count++;
                        }
                        sum = 0;
                    }
                }
                if(sum == K){
                    count++;
                }
                sum = 0;
            }
            sum = 0;
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[i].length; j++){
                    if(board[j][i] == 1){
                        sum++;
                    }else{
                        if(sum == K){
                            count++;
                        }
                        sum = 0;
                    }
                }
                if(sum == K){
                    count++;
                }
                sum = 0;
            }
            System.out.printf("#%d %d\n", test_case, count);
        }
    }
}