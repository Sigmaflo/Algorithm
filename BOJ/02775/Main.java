import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i = 0; i < t; i++){
            int k = scan.nextInt();
            int n = scan.nextInt();
            int[][] room = new int[k+1][n+1];
            for(int no = 1; no <= n; no++){
                room[0][no] = no;
            }
            for(int floor = 1; floor <= k; floor++){
                for(int no = 0; no <= n; no++){
                    int sum = 0;
                    for(int u = 0; u <= no; u++){
                        sum += room[floor-1][u];
                    }
                    room[floor][no] = sum;
                }
            }
            System.out.println(room[k][n]);
        }
    }
}
