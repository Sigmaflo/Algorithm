import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static Map<Integer, Integer> ht;

    static class Paper{
        int x;
        int y;
        int n;

        public Paper(int x, int y, int n){
            this.x = x;
            this.y = y;
            this.n = n;
        }
    }

    static boolean isAllSameNumber(Paper paper){
        int x = paper.x;
        int y = paper.y;
        int n = paper.n;
        boolean isSameNumber = true;
        int c = board[x][y];
        for(int i = x; i < x + n; i++){
            for(int j = y; j < y + n; j++){
                if(board[i][j] != c){
                    isSameNumber = false;
                    break;
                }
            }
            if(!isSameNumber){
                break;
            }
        }
        return isSameNumber;
    }

    static void search(Paper[] papers){
        for(Paper paper : papers){
            if(isAllSameNumber(paper)){
                ht.put(board[paper.x][paper.y], ht.get(board[paper.x][paper.y])+1);
            }else{
                Paper[] papers1 = new Paper[9];
                int k = 0;
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        int nx = paper.x + (paper.n/3 * i);
                        int ny = paper.y + (paper.n/3 * j);
                        papers1[k] = new Paper(nx, ny, paper.n/3);
                        k++;
                    }
                }
                search(papers1);
            }
        }

    }

    public static void main(String[] args) throws IOException {
        ht = new HashMap<>();
        ht.put(-1 , 0);
        ht.put(0 , 0);
        ht.put(1 , 0);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Paper[] papers = new Paper[1];
        papers[0] = new Paper(0, 0, N);
        if(!isAllSameNumber(papers[0])){
            search(papers);
        }else{
            ht.put(board[0][0], ht.get(board[0][0]) + 1);
        }
        System.out.println(ht.get(-1));
        System.out.println(ht.get(0));
        System.out.println(ht.get(1));
    }
}