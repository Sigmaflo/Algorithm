import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int bule;
    static int white;
    static int[][] board;

    static class Dot{
        int x;
        int y;

        public Dot(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static boolean check(Dot dot, int color, int n){
        boolean isSameColor = true;
        for(int i = dot.x; i < n+dot.x; i++){
            for(int j = dot.y; j < n+dot.y; j++){
                if(board[i][j] != color){
                    isSameColor = false;
                    break;
                }
            }
            if(!isSameColor){
                break;
            }
        }
        return isSameColor;
    }

    static void search(Dot[] dots, int n){
        for(Dot dot : dots){
            if(check(dot, 0, n)){
                white++;
            }else if(check(dot, 1, n)){
                bule++;
            }else{
                int nextN = n / 2;
                Dot[] nextDots = new Dot[4];
                nextDots[0] = new Dot(dot.x, dot.y);
                nextDots[1] = new Dot(dot.x+nextN, dot.y);
                nextDots[2] = new Dot(dot.x, dot.y+nextN);
                nextDots[3] = new Dot(dot.x+nextN, dot.y+nextN);
                search(nextDots, nextN);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Dot[] dots = new Dot[1];
        dots[0] = new Dot(0, 0);
        search(dots, n);
        System.out.println(white);
        System.out.println(bule);
    }
}
