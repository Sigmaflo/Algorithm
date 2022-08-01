import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] switches = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            switches[i] = Integer.parseInt(st.nextToken());
        }
        int people = Integer.parseInt(br.readLine());
//        for(int i = 1; i < switches.length; i++){
//            System.out.print(switches[i]+" ");
//        }
//        System.out.println(" ");
        for(int p = 0; p < people; p++){
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
//            System.out.println(sex + " " + num);
            if(sex == 1){//남자
                for(int i = num; i < switches.length; i+=num){
                    if(switches[i] == 0){
                        switches[i] = 1;
                    }else{
                        switches[i] = 0;
                    }
                }
            }else if(sex == 2){//여자
                if(switches[num] == 0){
                    switches[num] = 1;
                }else{
                    switches[num] = 0;
                }
                for(int i = 1; i < switches.length; i++){
                    if(num - i < 1 || num + i > switches.length-1){
                        break;
                    }
                    if(switches[num-i] != switches[num+i]){
                        break;
                    }
                    if(switches[num-i] == 0){
                        switches[num-i] = 1;
                    }else{
                        switches[num-i] = 0;
                    }
                    if(switches[num+i] == 0){
                        switches[num+i] = 1;
                    }else{
                        switches[num+i] = 0;
                    }
                }
            }
//            for(int i = 1; i < switches.length; i++){
//                System.out.print(switches[i]+" ");
//            }
//            System.out.println(" ");
        }
        for(int i = 1; i < switches.length; i++){
            if(i % 20 == 0){
                System.out.println(switches[i]);
            }else{
                System.out.print(switches[i]+" ");
            }
        }
    }
}
