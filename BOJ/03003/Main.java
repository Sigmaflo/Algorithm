import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] A = {1, 1, 2, 2, 2, 8};
        for (int i = 0; i < 6; i++) {
            int num = scan.nextInt();
            System.out.print(A[i] - num + " ");
        }
    }
}
