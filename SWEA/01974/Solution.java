import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static int check_sudoku(int[][] sudoku){
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                set.add(sudoku[i][j]);
            }
            if(set.size() != 9){
                return 0;
            }
            set.clear();
        }

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                set.add(sudoku[j][i]);
            }
            if(set.size() != 9){
                return 0;
            }
            set.clear();
        }

        for(int i = 0; i < 9; i++){
            int[] arr = {0, 3, 6};
            int a = arr[i / 3];
            int b = arr[i % 3];
            set.add(sudoku[a][b]);
            int na = a;
            int nb = b;
            for(int j = 0; j < 8; j++){
                if(nb < b + 2){
                    nb++;
                }else{
                    nb = b;
                    na++;
                }
                set.add(sudoku[na][nb]);
            }
            if(set.size() != 9){
                return 0;
            }
            set.clear();
        }

        return 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        for(int testcase = 1; testcase <= t; testcase++){
            int[][] sudoku = new int[9][9];
            for(int i = 0; i < 9; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 9; j++) {
                    sudoku[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int result = check_sudoku(sudoku);
            System.out.printf("#%d %d\n",testcase, result);
        }
    }
}
