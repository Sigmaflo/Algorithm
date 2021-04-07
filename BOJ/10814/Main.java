import java.util.*;
import java.io.*;

public class Main {
    static class Member implements Comparable<Member>{
        int age;
        String name;

        public Member(int _age, String _name){
            this.age = _age;
            this.name = _name;
        }

        public int compareTo(Member o){
            if(this.age != o.age){
                return this.age > o.age ? 1 : -1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Member> list = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String[] inputs = br.readLine().split(" ");
            int age = Integer.parseInt(inputs[0]);
            String name = inputs[1];
            Member member = new Member(age, name);
            list.add(member);
        }
        Collections.sort(list);
        for(Member member : list){
            System.out.println(member);
        }
    }
}
