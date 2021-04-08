import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<String> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String[] command = br.readLine().split(" ");
            if(command[0].equals("push_front")){
                list.add(0, command[1]);
            }else if(command[0].equals("push_back")){
                list.add(command[1]);
            }else if(command[0].equals("pop_front")){
                if(list.isEmpty()){
                    bw.write("-1");
                }else{
                    bw.write(list.remove(0));
                }
                bw.newLine();
            }else if(command[0].equals("pop_back")){
                if(list.isEmpty()){
                    bw.write("-1");
                }else{
                    bw.write(list.remove(list.size()-1));
                }
                bw.newLine();
            }else if(command[0].equals("size")){
                bw.write(Integer.toString(list.size()));
                bw.newLine();
            }else if(command[0].equals("empty")){
                if(list.isEmpty()){
                    bw.write("1");
                }else{
                    bw.write("0");
                }
                bw.newLine();
            }else if(command[0].equals("front")){
                if(list.isEmpty()){
                    bw.write("-1");
                }else{
                    bw.write(list.get(0));
                }
                bw.newLine();
            }else if(command[0].equals("back")){
                if(list.isEmpty()){
                    bw.write("-1");
                }else{
                    bw.write(list.get(list.size()-1));
                }
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}
