import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] lamps = new int[str.length()+1];
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'Y'){
                lamps[i+1] = 1;
            }else{
                lamps[i+1] = -1;
            }
        }
        int count = 0;
        boolean end = true;
        for(int i = 1; i <= str.length(); i++){
            if(lamps[i] == 1){
                end = false;
                break;
            }
        }
        if(!end){
            for(int i = 1; i <= str.length(); i++){
                if(lamps[i] == -1){
                    continue;
                }
                count++;
                for(int j = i; j <= str.length(); j+=i){
                    lamps[j] *= -1;
                }
                end = true;
                for(int k = 1; k <= str.length(); k++){
                    if(lamps[k] == 1){
                        end = false;
                        break;
                    }
                }
                if(end){
                    break;
                }
            }
        }
        if(end){
            System.out.println(count);
        }else{
            System.out.println(-1);
        }
    }
}
