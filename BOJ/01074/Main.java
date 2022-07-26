import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int count = 0;

    public static void find(int line, int y, int x){
        if(line == 1){
            return;
        }
        if(y < line/2 && x < line/2) {
            find(line/2, y, x);
        }
		else if(y < line/2 && x >= line/2) {
            count += line * line / 4;
            find(line/2, y, x - line/2);
        }
        else if(y >= line/2 && x < line/2) {
            count += (line * line / 4) * 2;
            find(line/2, y - line/2, x);
        }
        else {
            count += (line * line / 4) * 3;
            find(line/2, y - line/2, x - line/2);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        find((int)Math.pow(2, N), r, c);
        System.out.println(count);
    }
}
