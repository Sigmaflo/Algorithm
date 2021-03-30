import java.util.*;
import java.io.*;

public class Main {
    static class Name implements Comparable<Name>{
        String name;

        public Name(String _name){
            this.name = _name;
        }

        @Override
        public int compareTo(Name o) {
            if(this.name.length() != o.name.length()){
                return this.name.length() > o.name.length() ? 1 : -1;
            }else{
                return this.name.compareTo(o.name);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Name> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            String _name = br.readLine();
            int s1 = set.size();
            set.add(_name);
            int s2 = set.size();
            if(s2 > s1){
                Name name = new Name(_name);
                list.add(name);
            }
        }
        Collections.sort(list);
        for(Name nn: list){
            System.out.println(nn.name);
        }
    }
}
