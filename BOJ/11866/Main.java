import java.util.*;
import java.io.*;

public class Main {
    static boolean[] arr;
    static int position;

    private static int get_index(int p){
        int index = p % arr.length;
        if(index == 0){
            position++;
            return 1;
        }else{
            return index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new boolean[n+1];
        position = 1;
        int count = 1;
        List<Integer> result = new ArrayList<>();
        Arrays.fill(arr, false);
        for(int i = 1; i < arr.length; i++){
            boolean is_removed = false;
            while(!is_removed){
                int t = get_index(get_index(position));
                if(count >= k && !arr[get_index(position)]){
                    arr[get_index(position)] = true;
                    is_removed = true;
                    count = 0;
                    result.add(get_index(position));
                }else{
                    position++;
                    if(!arr[get_index(position)]){
                        count++;
                    }
                }
            }

        }
        bw.write("<");
        for(int i = 0; i < result.size(); i++){
            if(i+1 != result.size()){
                bw.write(Integer.toString(result.get(i))+", ");
            }else{
                bw.write(Integer.toString(result.get(i)));
            }
        }
        bw.write(">");
        bw.flush();
        bw.close();
    }
}
