import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[10001];
        for(int i = 1; i <= 10000; i++){
            arr[i] = 0;
        }
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            arr[num]++;
        }
        for(int i = 1; i <= 10000; i++){
            for(int j = 0; j < arr[i]; j++){
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }
}
